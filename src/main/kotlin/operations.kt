

sealed class Operations {
    data class Addition(val timestamp1: Long, val timestamp2: Long) : Operations()
    data class Subtraction(val timestamp1: Long, val timestamp2: Long) : Operations()
    data class Multiplication(val timestamp1: Long, val factor: Int) : Operations()
    data class Division(val timestamp1: Long, val divisor: Int) : Operations()
}