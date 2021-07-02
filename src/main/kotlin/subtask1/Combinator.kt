package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        for ( i in 0 .. array[0]) {
            if((factorial(array[1]) / (factorial(i) * factorial(array[1] - i))).toInt() == array[0])
                return i
        }
        return null
    }
}

private fun factorial(num: Int): Double{
    var result = 1.0
    for(i in 1 .. num){
        result *= i
    }
    return result
}
