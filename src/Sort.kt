import java.io.File
import java.nio.file.Paths

class Sort(override val shakespeareList: Array<String> = File("${Paths.get("").toAbsolutePath()}/src/shakespeare-complete-works.txt").toTypedArray()) :
    Sorting {

    // Used for Trie
    private val root: TrieNode = TrieNode()

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    override fun bubbleSort() {
        val length = shakespeareList.size                     
        for (i in 0 until length) {                           
            for (j in 0 until length - i - 1) {               
                if (shakespeareList[j] > shakespeareList[j + 1]) { 
                    val word = shakespeareList[j]           
                    shakespeareList[j] = shakespeareList[j + 1]    
                    shakespeareList[j + 1] = word              
                }
            }
        }
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    override fun selectionSort() {
        for (i in shakespeareList.indices) {               // O(n)
            var min = i                                    // O(1)
            for (j in i + 1 until shakespeareList.size) {    // O(n)
                if (shakespeareList[j] < shakespeareList[min]) { // O(1)
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
                    shakespeareList[j] = tmp                          //
                }
            }
        }
    }

    // Time complexity: O(n log n)
    // Space complexity: O(1)
    override fun heapSort() {

        val n = shakespeareList.size

        for (i in n / 2 - 1 downTo 0) /* O(n) */ heapify(shakespeareList, n, i) // O(log n) --> O(n log n)

        for (i in n - 1 downTo 0) {                      // O(n)|
            val temp = shakespeareList[0]             // O(1) |
            shakespeareList[0] = shakespeareList[i]          // O(1) |--------> // O(n log n)
            shakespeareList[i] = temp                        // O(1) |
            heapify(shakespeareList, i, 0)                // O(log n) |
        }
    }

    override fun heapify(arr: Array<String>, n: Int, i: Int) {
        var largest = i

        val l = 2 * i + 1

        val r = 2 * i + 2

        if (l < n && arr[l] > arr[largest]) largest = l

        if (r < n && arr[r] > arr[largest]) largest = r

        if (largest != i) {
            val swap = arr[i]
            arr[i] = arr[largest]
            arr[largest] = swap
            heapify(arr, n, largest)
        }
    }

    fun initMergeSort() = mergeSort(shakespeareList, 0, shakespeareList.size - 1)


    // Time complexity: O(n log n)
    // Space complexity: O(n)
    override fun mergeSort(array: Array<String>, from: Int, to: Int) {
        if (from === to) {                           //
            return                                   // O(1)
        }                                            //
        val mid: Int = (from + to) / 2               // O(1)
        mergeSort(array, from, mid)                  // T(n/2)
        mergeSort(array, mid + 1, to)          // T(n/2)
        merge(array, from, mid, to)                  // O(n)
    }

    override fun merge(array: Array<String>, from: Int, mid: Int, to: Int) {
        val n = to - from + 1                                                       //
        //
        val b =                                                           //
            arrayOfNulls<String>(n)                                                      //
        //
        var i1 = from                                                               // O(1)
        //
        var i2 = mid + 1                                                            //
        //
        var j = 0                                                                        //


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


        while (i1 <= mid) {                                                             // O(n)
            b[j] = array[i1]
            i1++
            j++
        }

        while (i2 <= to) {                                                              // O(n)
            b[j] = array[i2]
            i2++
            j++
        }

        for (j in 0 until n) {                        // O(n)
            array[from + j] = b[j]!!                       // O(1)
        }
    }

    // Time complexity: O(n^2)
    // Space complexity: O(n)
    override fun treeIfy() {
        for (word in shakespeareList) { // O(n)
            var current: TrieNode = root // O(1)
            for (element in word) { // O(n)
                current = current.children
                    .computeIfAbsent(element) { TrieNode() } // O(1)
            }
            current.isWord = true // O(1)
        }
    }

}

class TrieNode {
    val children: MutableMap<Char, TrieNode> = HashMap()
    var isWord = false
}
