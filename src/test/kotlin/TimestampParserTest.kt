import org.junit.Test
import kotlin.test.assertEquals


class TimestampParserClass {
    @Test fun testBasicMillisParsing() {
        assertEquals(100, fixMillisecond("1"))
        assertEquals(120, fixMillisecond("12"))
        assertEquals(123, fixMillisecond("123"))
        assertEquals(12, fixMillisecond("012"))
        assertEquals(10, fixMillisecond("010"))
        assertEquals(10, fixMillisecond("01"))
        assertEquals(1, fixMillisecond("001"))
    }
    @Test fun testTimeStampParsing() {
        assertEquals(Timestamp(0,31,12,42), parseTimestamp("00:31:12.042"))
        assertEquals(Timestamp(0,31,12,42), parseTimestamp("31:12.042"))
        assertEquals(Timestamp(0,0,12,42), parseTimestamp("12.042"))
        assertEquals(Timestamp(0,0,42,0), parseTimestamp("42"))
        assertEquals(Timestamp(0,0,0,42), parseTimestamp("0.042"))
        assertEquals(Timestamp(0,0,0,12), parseTimestamp(".012"))
        assertEquals(null, parseTimestamp("ABC"))
    }
}