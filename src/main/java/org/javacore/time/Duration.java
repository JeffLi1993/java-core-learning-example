package org.javacore.time;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title: Duration
 * Create Date: 2016-08-26 15:43
 * Description: Duration unit, consisting of length and time unit.
 * Simple time convert.
 *
 * @author Yufan
 */
public class Duration implements Serializable {
    private static final long serialVersionUID = 3898309763927286550L;

    /**
     * A duration of Long.MAX_VALUE Days
     */
    public static final Duration INFINITE = new Duration();

    /**
     * Common time pattern
     */
    private static final Pattern PATTERN = Pattern.compile(
        "(∞|inf|infinite)|" + "(([\\d]+)[\\s]*(" + "ns|nanosecond(s)?|" + "us|microsecond(s)?|" + "ms|millisecond(s)?|" + "s|second(s)?|"
            + "m|min|mins|minute(s)?|" + "h|hour(s)?|" + "d|day(s)?" + "))");
    private static final Map<String, TimeUnit> SUFFIXES;

    public final long length;
    public final TimeUnit timeUnit;
    public final boolean finite;

    static {
        SUFFIXES = Maps.newHashMapWithExpectedSize(32);

        SUFFIXES.put("ns", TimeUnit.NANOSECONDS);
        SUFFIXES.put("nanosecond", TimeUnit.NANOSECONDS);
        SUFFIXES.put("nanoseconds", TimeUnit.NANOSECONDS);

        SUFFIXES.put("us", TimeUnit.MICROSECONDS);
        SUFFIXES.put("microsecond", TimeUnit.MICROSECONDS);
        SUFFIXES.put("microseconds", TimeUnit.MICROSECONDS);

        SUFFIXES.put("ms", TimeUnit.MILLISECONDS);
        SUFFIXES.put("millisecond", TimeUnit.MILLISECONDS);
        SUFFIXES.put("milliseconds", TimeUnit.MILLISECONDS);

        SUFFIXES.put("s", TimeUnit.SECONDS);
        SUFFIXES.put("second", TimeUnit.SECONDS);
        SUFFIXES.put("seconds", TimeUnit.SECONDS);

        SUFFIXES.put("m", TimeUnit.MINUTES);
        SUFFIXES.put("min", TimeUnit.MINUTES);
        SUFFIXES.put("mins", TimeUnit.MINUTES);
        SUFFIXES.put("minute", TimeUnit.MINUTES);
        SUFFIXES.put("minutes", TimeUnit.MINUTES);

        SUFFIXES.put("h", TimeUnit.HOURS);
        SUFFIXES.put("hour", TimeUnit.HOURS);
        SUFFIXES.put("hours", TimeUnit.HOURS);

        SUFFIXES.put("d", TimeUnit.DAYS);
        SUFFIXES.put("day", TimeUnit.DAYS);
        SUFFIXES.put("days", TimeUnit.DAYS);
    }

    /**
     * Infinite constructor.
     */
    private Duration() {
        finite = false;
        this.length = Long.MAX_VALUE;
        this.timeUnit = TimeUnit.DAYS;
    }

    private Duration(long length, TimeUnit timeUnit) {
        this.length = length;
        this.timeUnit = Preconditions.checkNotNull(timeUnit, "timeUnit");
        finite = !(length == Long.MAX_VALUE && TimeUnit.DAYS.equals(timeUnit));
    }

    /**
     * Returns the Duration converted to days.
     */
    public long toDays() {
        return TimeUnit.DAYS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to hours.
     */
    public long toHours() {
        return TimeUnit.HOURS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to microseconds.
     */
    public long toMicros() {
        return TimeUnit.MICROSECONDS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to microseconds.
     */
    public long toMicroseconds() {
        return TimeUnit.MICROSECONDS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to milliseconds.
     */
    public long toMillis() {
        return TimeUnit.MILLISECONDS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to milliseconds.
     */
    public long toMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to minutes.
     */
    public long toMins() {
        return TimeUnit.MINUTES.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to minutes.
     */
    public long toMinutes() {
        return TimeUnit.MINUTES.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to nanoseconds.
     */
    public long toNanos() {
        return TimeUnit.NANOSECONDS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to nanoseconds.
     */
    public long toNanoseconds() {
        return TimeUnit.NANOSECONDS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to seconds.
     */
    public long toSeconds() {
        return TimeUnit.SECONDS.convert(length, timeUnit);
    }

    /**
     * Returns the Duration converted to seconds.
     */
    public long toSecs() {
        return TimeUnit.SECONDS.convert(length, timeUnit);
    }

    /**
     * Returns a Duration of {@code count} days.
     */
    public static Duration days(long count) {
        return new Duration(count, TimeUnit.DAYS);
    }

    /**
     * Returns a Duration of {@code count} hours.
     */
    public static Duration hours(long count) {
        return new Duration(count, TimeUnit.HOURS);
    }

    /**
     * Returns an infinite duration of Long.MAX_VALUE days.
     */
    public static Duration inf() {
        return INFINITE;
    }

    /**
     * Returns an infinite duration of Long.MAX_VALUE days.
     */
    public static Duration infinite() { // NOSONAR
        return INFINITE;
    }

    /**
     * Returns a Duration of {@code count} microseconds.
     */
    public static Duration microseconds(long count) {
        return new Duration(count, TimeUnit.MICROSECONDS);
    }

    /**
     * Returns a Duration of {@code count} milliseconds.
     */
    public static Duration millis(long count) {
        return new Duration(count, TimeUnit.MILLISECONDS);
    }

    /**
     * Returns a Duration of {@code count} milliseconds.
     */
    public static Duration milliseconds(long count) {
        return new Duration(count, TimeUnit.MILLISECONDS);
    }

    /**
     * Returns a Duration of {@code count} minutes.
     */
    public static Duration mins(long count) {
        return new Duration(count, TimeUnit.MINUTES);
    }

    /**
     * Returns a Duration of {@code count} minutes.
     */
    public static Duration minutes(long count) {
        return new Duration(count, TimeUnit.MINUTES);
    }

    /**
     * Returns a Duration of {@code count} nanoseconds.
     */
    public static Duration nanos(long count) {
        return new Duration(count, TimeUnit.NANOSECONDS);
    }

    /**
     * Returns a Duration of {@code count} nanoseconds.
     */
    public static Duration nanoseconds(long count) {
        return new Duration(count, TimeUnit.NANOSECONDS);
    }

    /**
     * Returns a Duration of {@code count} {@code unit}s.
     */
    public static Duration of(long count, TimeUnit unit) {
        return new Duration(count, unit);
    }

    /**
     * Returns a Duration from the parsed {@code duration}. Example:
     * <br />
     * <pre>
     * 5 s
     * 5 seconds
     * 10m
     * 10 minutes
     * </pre>
     */
    public static Duration of(String duration) {
        Matcher matcher = PATTERN.matcher(duration);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid duration: " + duration);
        }

        if (matcher.group(1) != null) {
            return INFINITE;
        } else {
            String unit = matcher.group(4);
            String value = matcher.group(3);
            return new Duration(Long.parseLong(value), SUFFIXES.get(unit));
        }
    }

    /**
     * Returns a Duration of {@code count} seconds.
     */
    public static Duration seconds(long count) {
        return new Duration(count, TimeUnit.SECONDS);
    }

    /**
     * Returns a Duration of {@code count} seconds.
     */
    public static Duration secs(long count) {
        return new Duration(count, TimeUnit.SECONDS);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final Duration duration = (Duration) obj;
        return (length == duration.length) && (timeUnit == duration.timeUnit);
    }

    @Override
    public int hashCode() {
        return (31 * (int) (length ^ (length >>> 32))) + timeUnit.hashCode();
    }

    @Override
    public String toString() {
        String units = timeUnit.toString().toLowerCase();
        if (length == 1)
            units = units.substring(0, units.length() - 1);
        return Long.toString(length) + ' ' + units;
    }
}
