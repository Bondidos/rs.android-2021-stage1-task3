package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val keyBoard = arrayOf<Array<String>>(
            arrayOf("1","2","3"),
            arrayOf("4","5","6"),
            arrayOf("7","8","9"),
            arrayOf("*","0","#")
        )

        val result = ArrayList<String>()
        result.findNeighbors(number,keyBoard)
        result.forEach {println(it)}
        throw NotImplementedError("Not implemented")
    }
}
fun ArrayList<String>.findNeighbors(number: String,keyBoard: Array<Array<String>>) {
    var coordinates = 0 to 0
    for(i in keyBoard.indices){
        for(j in keyBoard[i].indices)
            if(number == keyBoard[i][j])
                coordinates = i to j
    }
    for(i in 0 ..3)
    when{
        coordinates.first -1 >= 0 -> this.add(keyBoard[coordinates.first - 1][coordinates.second])
        coordinates.first +1 <= 3 -> this.add(keyBoard[coordinates.first + 1][coordinates.second])
        coordinates.second -1 >= 0 -> this.add(keyBoard[coordinates.first][coordinates.second - 1])
        coordinates.second +1 >= 2 -> this.add(keyBoard[coordinates.first][coordinates.second + 1])
    }
}
