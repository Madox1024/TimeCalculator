import java.lang.NumberFormatException

data class Timestamp(
    val hour: Int,
    val minute: Int,
    val second: Int,
    val millisecond: Int
)

// Attempts to parse given string and return Timestamp class, returns null if Regex fails
fun parseTimestamp(string: String): Timestamp? {
    val timeStampGet = """(\d*?):?(\d{0,2}?):?(\d*)\.?(\d{0,3})$""".toRegex()
    return timeStampGet.matchEntire(string)
        ?.destructured
        ?.let { (hour, minute, second, millisecond) ->
            Timestamp(hour.safeToInt(), minute.safeToInt(), second.safeToInt(), fixMillisecond(millisecond))
        }
        ?: return null
}
// Fixes dropped zeros e.g. ".12" = 120ms
fun fixMillisecond(milliseconds: String): Int {
    return if(milliseconds.length >= 3){
        milliseconds.safeToInt()
    }
    else {
        (milliseconds + "000".substring(0, 3-milliseconds.length)).safeToInt()
    }
}

// Returns 0 if String.toInt() fails
fun String.safeToInt(): Int {
    return try {
        this.toInt()
    } catch (ignored: NumberFormatException) {0}
}
