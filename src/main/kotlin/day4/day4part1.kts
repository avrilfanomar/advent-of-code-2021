import  java.io.File

val matrixSize = 5

val lines = File("input.txt").readLines()
val integers = lines[0].split(',').map { it.toInt() }

val matrixList = ArrayList<Array<IntArray>>()
val selectionMatrixList = ArrayList<Array<IntArray>>()

readMatrixList()

var finalMatrixIdx = 0
var finalValue = 0
mainLoop@ for (nextChosenValue in integers) {
    for ((matrixIndex, selectionMatrix) in selectionMatrixList.withIndex()) {
        for (i in 0 until matrixSize) {
            for (j in 0 until matrixSize) {
                if (matrixList[matrixIndex][i][j] == nextChosenValue) {
                    selectionMatrix[i][j] = 1
                    if (horizontalStrike(selectionMatrix, i)
                        || verticalStrike(selectionMatrix, j)
                    ) {
                        finalMatrixIdx = matrixIndex
                        finalValue = nextChosenValue
                        break@mainLoop
                    }
                }
            }
        }
    }
}

var unmarkedSum = 0
for (row in 0 until matrixSize) {
    for (col in 0 until matrixSize) {
        if (selectionMatrixList[finalMatrixIdx][row][col] == 0) {
            unmarkedSum += matrixList[finalMatrixIdx][row][col]
        }
    }
}

println(unmarkedSum * finalValue)


fun readMatrixList() {
    var matrixIdx = -1
    var i = 0
    var j = 0
    for (line in lines.subList(1, lines.size)) {
        line.split(' ').forEach {
            try {
                val nextInt = it.trim().toInt()
                if (i == 0 && j == 0) {
                    matrixList.add(Array(matrixSize) { IntArray(matrixSize) })
                    selectionMatrixList.add(Array(matrixSize) { IntArray(matrixSize) { 0 } })
                    matrixIdx++
                }
                matrixList[matrixIdx][i][j] = nextInt
                if (i == matrixSize - 1 && j == matrixSize - 1) {
                    i = 0
                    j = 0
                } else if (j != matrixSize - 1) {
                    j++
                } else if (j == matrixSize - 1) {
                    i++
                    j = 0
                }
            } catch (_: Exception) {
            }
        }
    }
}

fun horizontalStrike(matrix: Array<IntArray>, i: Int): Boolean {
    return matrix[i].sum() == matrixSize
}

fun verticalStrike(matrix: Array<IntArray>, j: Int): Boolean {
    var sum = 0
    for (i in 0 until matrixSize) {
        sum += matrix[i][j]
    }
    return sum == matrixSize
}
