package subtask2

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val list = mutableListOf<ArrayList<Int>>()
        val remain = number.pow() - (number - 1).pow()

        for(x in 0 .. remain)
            for(y in 0 .. remain)
                for(z in 0 .. remain)
                    for(t in 0 .. remain)
                        if (x*x + y*y + z*z + t*t == remain){
                            val collision = ArrayList<Int>()
                            collision.add(x)
                            collision.add(y)
                            collision.add(z)
                            collision.add(t)
                            collision.add(number-1)
                            if(collision.isIncreasing())
                                list.add(collision)
                        }
       // list.forEach { println(it) }
       // val arr = list.findValid()
       // arr.forEach { println(it) }
        //return list.findValid()
        throw NotImplementedError("Not implemented")
    }
}

    fun Int.pow() = this * this

    fun ArrayList<Int>.isIncreasing(): Boolean{
        for(i in this.size-1  downTo 1){
            if(this[i] <= this[i-1])
                return false
        }
        return true
    }
fun MutableList<ArrayList<Int>>.findValid(): Array<Int>{
    var buffer = ArrayList<Int>()
    for (i in this){
        if(this.indexOf(i) == 0)
            buffer = i
        if (buffer.size > i.size)
            buffer = i
        if (buffer.size == i.size)
            buffer = compareArrays(buffer,i) ?:i
    }
    return buffer.toTypedArray()
}
fun compareArrays(arr1:ArrayList<Int>, arr2:ArrayList<Int>): ArrayList<Int>{
    for (i in arr1.size -1 downTo 1){
        if(arr1 == arr2) return arr1
        if(arr1[i] == arr2[i]) continue
        if (arr1[i] < arr2[i]) return arr2
        if (arr1[i] > arr2[i]) return arr1
    }
    return arr1
}