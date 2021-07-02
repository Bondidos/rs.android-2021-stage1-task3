package subtask2

import kotlin.math.pow
import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        var number = number.toDouble().pow(2.0).toInt()
        val result = mutableListOf<Int>()
        var remain = 0
            if(!number.isFermaEller()){

            }
            if(number.isFermaEller()) {
                result.add((number-2).sqrt())
                result.add((number - result.last().pow()).sqrt())
            }

        result.reverse()
        result.forEach { println(it) }
        throw NotImplementedError("Not implemented")
    }
}
fun Int.sqrt() = sqrt(this.toDouble()).toInt()
fun Int.isFermaEller (): Boolean = (this/4)*4 +1 == this
fun Int.pow() = this * this
