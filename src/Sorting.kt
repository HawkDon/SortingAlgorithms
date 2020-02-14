interface Sorting {

    val shakespeareList: Array<String>

    /*
    When to use BubbleSort:
    When input is already sorted
    Space is a concern
    Easy to implement

    When to not use BubbleSort:
    Average case time complexity is poor
     */
    fun bubbleSort()


    /*
    When to use SelectionSort:
    When we don't have additional memory
    Want easy implementation

    When to not use SelectionSort:
    When time complexity is a concern
     */
    fun selectionSort()

    /*
    When to use InsertionSort:
    No extra space
    Simple implementation
    Best when we have continuous inflow of numbers and we want to keep the list shorted

    When to not use InsertionSort:
    Average case is bad
    */
    fun insertionSort()


    /*


    */
    fun heapSort()


    /*
    When to use MergeSort:
    When you need a stable sort
    When average expected time is O(n log n)

    When to not use MergeSort:
    When space is a concern like embedded systems
    */
    fun mergeSort(array: Array<String>, from: Int, to: Int)
    fun merge(array: Array<String>, from: Int, mid: Int, to: Int)
}