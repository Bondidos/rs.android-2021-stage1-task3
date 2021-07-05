package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val keyBoard = arrayOf(
            arrayOf('1','2','3'),
            arrayOf('4','5','6'),
            arrayOf('7','8','9'),
            arrayOf('*','0','#')
        )
        return number.findNeighbors(keyBoard)
    }
}
fun String.findNeighbors(keyBoard: Array<Array<Char>>): Array<String>? {
    val result = arrayListOf<String>()
    var coordinates : Pair<Int,Int>?
    for (i in this.indices) {
        coordinates = findCoordinates(keyBoard, this[i])
        if(coordinates == null) return null
        if (coordinates.first - 1 >= 0) {
            result.add(this.replaceRange(i..i, keyBoard[coordinates.first - 1][coordinates.second].toString()))
        }
        if (coordinates.first + 1 <= 3 &&
            keyBoard[coordinates.first + 1][coordinates.second] != '*'  &&
            keyBoard[coordinates.first + 1][coordinates.second] != '#') {
            result.add(this.replaceRange(i .. i, keyBoard[coordinates.first + 1][coordinates.second].toString()))
        }
        if (coordinates.second - 1 >= 0 &&
            keyBoard[coordinates.first][coordinates.second - 1] != '*') {
            result.add(this.replaceRange(i..i, keyBoard[coordinates.first][coordinates.second - 1].toString()))
        }
        if (coordinates.second + 1 <= 2 &&
            keyBoard[coordinates.first][coordinates.second + 1] != '#') {
            result.add(this.replaceRange(i..i, keyBoard[coordinates.first][coordinates.second + 1].toString()))
        }
    }
    return result.toTypedArray()
}

fun findCoordinates(keyBoard: Array<Array<Char>>, char: Char): Pair<Int,Int>?{

    for(i in keyBoard.indices)
        for(j in keyBoard[i].indices)
            if(char == keyBoard[i][j])
               return i to j
    return  null
}