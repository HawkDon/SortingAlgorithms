import java.io.File
import java.nio.file.Paths

fun main() {
    val sort1 = Sort()
    val sort2 = Sort()
    val sort3 = Sort()
    val sort4 = Sort()
    val sort5 = Sort()
    println(stopwatch {
        sort1.bubbleSort() // Around 48 mil sec
    })
    println(stopwatch {
        sort2.selectionSort() // Around 18 mil sec
    })
    println(stopwatch {
        sort3.insertionSort() // Around 23 mil sec
    })
    println(stopwatch {
        sort4.heapSort() // Around 1,7 mil sec
    })
    println(stopwatch {
        sort5.initMergeSort() //  Around 2,1 mil sec
    })
}
