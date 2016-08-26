package org.javacore.time;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class DurationTest {
    @Test
    public void testCombineTimeUtil() throws Exception {
        Assert.assertEquals(Duration.days(1).toMilliseconds(), 24 * 3600 * 1000);
        Assert.assertEquals(24 * 3600 * 1000 * 3, Duration.days(3).toMilliseconds());
        Assert.assertEquals(7 * 24 * 3600 * 1000 / 1000, Duration.days(7).toSeconds());
    }

    @Test
    public void testValidDurationStrings() throws Exception {
        Assert.assertEquals(Duration.of("5ns"), Duration.nanoseconds(5));
        Assert.assertEquals(Duration.of("5microsecond"), Duration.microseconds(5));
        Assert.assertEquals(Duration.of("5milliseconds"), Duration.millis(5));
        Assert.assertEquals(Duration.of("5 seconds"), Duration.seconds(5));
        Assert.assertEquals(Duration.of("5 minutes"), Duration.mins(5));
        Assert.assertEquals(Duration.of("5 hours"), Duration.hours(5));
        Assert.assertEquals(Duration.of("5 days"), Duration.days(5));
        Assert.assertEquals(Duration.of("inf"), Duration.inf());
        Assert.assertEquals(Duration.of("infinite"), Duration.inf());
        Assert.assertEquals(Duration.of("∞"), Duration.infinite());

        // Interesting value but legal nevertheless
        Assert.assertEquals(Duration.of("0s"), Duration.seconds(0));
    }

    private void testInvalidDurationString(String duration) {
        try {
            Duration.of(duration);
            fail("Duration string '" + duration + "' should not parse correctly.");
        } catch (IllegalArgumentException iae) {
            // Expected
        }
    }

    @Test
    public void testInvalidDurationStrings() {
        testInvalidDurationString("foobar");
        testInvalidDurationString("ms3");
        testInvalidDurationString("34 lightyears");
        testInvalidDurationString("34 seconds a day");
        testInvalidDurationString("5 days a week");
        testInvalidDurationString("");
        testInvalidDurationString("2");
        testInvalidDurationString("ns");
    }

    @Test
    public void testReplaceOldTimeUtils() {
        final int HOUR = 1000 * 60 * 60;
        long randomTimestamp = (long) (Math.random() * 400000000L) + 100000;
        Assert.assertEquals(randomTimestamp / HOUR, Duration.millis(randomTimestamp).toHours());
        Assert.assertEquals(randomTimestamp / 1000, Duration.millis(randomTimestamp).toSeconds());
    }
}
