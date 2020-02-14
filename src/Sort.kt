import java.io.File
import java.nio.file.Paths

class Sort(override val shakespeareList: Array<String> = File("${Paths.get("").toAbsolutePath()}/src/shakespeare-complete-works.txt").toTypedArray()) :
    Sorting {

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    override fun bubbleSort() {
        val length = shakespeareList.size                     // O(1)
        for (i in 0 until length) {                           // O(n)
            for (j in 0 until length - i - 1) {               // O(n)
                if (shakespeareList[j] > shakespeareList[j + 1]) { // O(1)
                    val word = shakespeareList[j]           //
                    shakespeareList[j] = shakespeareList[j + 1]    // O(1)
                    shakespeareList[j + 1] = word                  //
                }
            }
        }
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    override fun selectionSort() {
        for (i in shakespeareList.indices) {               // O(n)
            var min = i                                    // O(1)
            for (j in i+1 until shakespeareList.size) {    // O(n)
                if(shakespeareList[j] < shakespeareList[min]) { // O(1)
                    min = j                                     // O(1)
                }
            }
            val temp = shakespeareList[i]                //
            shakespeareList[i] = shakespeareList[min]           // O(1)
            shakespeareList[min] = temp                         //
        }
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    override fun insertionSort() {
        for (i in 1 until shakespeareList.size) {               // O(n)
            for (j in i downTo 1) {                             // O(n)
                if (shakespeareList[j - 1] > shakespeareList[j]) {   // O(1)
                    val tmp = shakespeareList[j - 1]          //
                    shakespeareList[j - 1] = shakespeareList[j]      // O(1)
                    shakespeareList[j]= tmp                          //
                }
            }
        }
    }

    override fun heapSort() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun initMergeSort() = mergeSort(shakespeareList, 0, shakespeareList.size - 1)


    // Time complexity: O(n log n)
    // Space complexity: O(n)
    override fun mergeSort(array: Array<String>, from: Int, to: Int) {
        if (from === to) {                           //
            return                                   // O(1)
        }                                            //
        val mid: Int = (from + to) / 2               // O(1)
        // sort the first and the second half
        mergeSort(array, from, mid)                  // T(n/2)
        mergeSort(array, mid + 1, to)          // T(n/2)
        merge(array, from, mid, to)                  // O(n)
    }

    override fun merge(array: Array<String>, from: Int, mid: Int, to: Int) {
        val n = to - from + 1 // size of the range to be merged                     //
                                                                                         //
        val b =                                                           //
            arrayOfNulls<String>(n) // merge both halves into a temporary array b )      //
                                                                                         //
        var i1 = from // next element to consider in the first range                // O(1)
                                                                                         //
        var i2 = mid + 1 // next element to consider in the second range            //
                                                                                         //
        var j = 0 // next open position in b                                             //


        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {                                                 // O(n)
            if (array[i1].compareTo(array[i2]) < 0) {
                b[j] = array[i1]
                i1++
            } else {
                b[j] = array[i2]
                i2++
            }
            j++
        }

        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {                                                             // O(n)
            b[j] = array[i1]
            i1++
            j++
        }

        // copy any remaining entries of the second half
        while (i2 <= to) {                                                              // O(n)
            b[j] = array[i2]
            i2++
            j++
        }

        // copy back from the temporary array
        for (j in 0 until n) {                        // O(n)
            array[from + j] = b[j]!!                       // O(1)
        }
    }

}