package subtask2

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return if (number < 3) return null
        else calculate(number.pow(), number - 1)?.toTypedArray()
    }
}
fun calculate (number: Int, index: Int): ArrayList<Int>?{
    for(i in index downTo 1){
        val remain = number - i.pow()
        if(remain == 0) return arrayListOf(i)
        if(remain < 0) return null
        var element = remain.sqrt()
        if(element >= i) element = i-1
        val result = calculate(remain, element)
        if(result !=null){
            result.add(i)
            return result
        }
    }
    return null
}

fun Int.pow() = this * this
fun Int.sqrt() = kotlin.math.sqrt(this.toDouble()).toInt()
