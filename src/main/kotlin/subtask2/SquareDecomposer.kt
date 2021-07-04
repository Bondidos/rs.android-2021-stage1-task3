package subtask2

class SquareDecomposer {
   // http://uneex.ru/FrBrGeorge/News/2017-02-01
    fun decomposeNumber(number: Int): Array<Int>? {
        val list = mutableListOf<ArrayList<Int>>()
        val remain = number.pow() - (number - 1).pow()
       var count = 0f
        var X = 0
        var y = 0
        var z = 0
        var t = 0

       for(x in 0 .. remain) {
           for (y in x..remain) {
               for (z in y..remain) {
                   for (t in z..remain) {
                       count++
                       if (x * x + y * y + z * z + t * t == remain) {
                           val collision = ArrayList<Int>()
                           collision.add(x)
                           collision.add(y)
                           collision.add(z)
                           collision.add(t)
                           collision.add(number - 1)
                           if (collision.isIncreasing())
                               list.add(collision)
                       }
                   }
                   }
           }
       }
       N = 99
       //scanf("%d", &N);
       //scanf("%d", &N);
       {
           x = 0
           while (x * x * 4 < N) {
               x++
           }
       }
       {
           Y = x
           while (x * x <= N) {
               while (Y >= N && (Y - 1) * (Y - 1) * 3 >= N - x * x) Y--
               y = Y.also({ Z = it })
               while (y <= x && x * x + y * y <= N) {
                   while (Z >= N && (Z - 1) * (Z - 1) * 2 >= N - x * x - y * y) Z--
                   z = Z.also({ t = it })
                   while (z <= y && x * x + y * y + z * z <= N) {
                       while (t * t > N - x * x - y * y - z * z) t--
                       count++
                       if (x * x + y * y + z * z + t * t == N) println(x.toString() + "," + y + "," + z + "," + t + "," + N)
                       z++
                   }
                   y++
               }
               x++
           }
       }
       println(+count)
       println(count)
        list.forEach { println(it) }
       // val arr = list.findValid()
       // arr.forEach { println(it) }
        return list.findValid()
        //throw NotImplementedError("Not implemented")
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