


fun main(){
    val ogInput = "1:30 * 2" //this is for testing, actual input will come from elsewhere
    handleInput(ogInput)
}

// Outsourcing main()
fun handleInput(ogInput: String) {
    val operator = getOperator(ogInput)
    if(operator == null){
        println("Invalid operator; please use '+', '-', '*', or '/'.")
        return
    }
    val splitInput = stringParser(ogInput, operator)

}

enum class Operator(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/')
}

// Attempts to find the operator in the given string and return it, if it can't it returns null
fun getOperator(ogInput: String): Operator? {
    for (operator in Operator.values()) {
        return if (operator.symbol in ogInput) {
            operator
        } else null
    }
    return null
}

// Splits the string by the given operator and returns the pair of strings
fun stringParser(ogInput: String, operator: Operator): Pair<String,String>{
    val result = ogInput.split(operator.symbol, limit = 2)
    return Pair(result[0].trim(), result[1].trim())
}
