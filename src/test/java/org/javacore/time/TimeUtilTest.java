package org.javacore.time;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.LocalDateTime;

import static org.javacore.time.TimeUtil.TimeFormat.LONG_DATE_PATTERN_DOUBLE_SLASH;
import static org.javacore.time.TimeUtil.TimeFormat.LONG_DATE_PATTERN_SLASH;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimeUtilTest {

    @Test
    public void testParseSpecificTimeStringByUsingDefaultPattern() throws Exception {
        LocalDateTime expectedDateTime = LocalDateTime.of(2014, 11, 11, 10, 11, 11);
        LocalDateTime parsedTime = TimeUtil.parseTime("2014-11-11 10:11:11");
        assertEquals(expectedDateTime, parsedTime);
    }

    @Test
    public void testParseSpecificTimeStringUsingTimeFormat() throws Exception {
        LocalDateTime expectedDateTime = LocalDateTime.of(2014, 11, 11, 10, 11, 11);
        LocalDateTime parsedTime = TimeUtil.parseTime("2014/11/11 10:11:11", LONG_DATE_PATTERN_SLASH);
        assertEquals(expectedDateTime, parsedTime);
    }

    @Test
    public void testParseLocalDateTimeByUsingDefaultFormatter() throws Exception {
        LocalDateTime time = LocalDateTime.of(2014, 11, 11, 10, 11, 11);
        assertEquals(TimeUtil.parseTime(time), "2014-11-11 10:11:11");
    }

    @Test
    public void testParseLocalDateTimeByUsingTimeFormat() throws Exception {
        LocalDateTime time = LocalDateTime.of(2014, 11, 11, 10, 11, 11);
        assertEquals(TimeUtil.parseTime(time, LONG_DATE_PATTERN_DOUBLE_SLASH), "2014\\11\\11 10:11:11");
    }
}
