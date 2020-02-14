import java.io.File

fun File.toTypedArray() = this.readLines()
    . flatMap { it.split (" ") }
    . filter { it.isNotEmpty () }
    .map {
        it.toLowerCase()
            .replace(Regex("[^A-Za-z0-9]"), "") }
    .toTypedArray()

fun stopwatch ( body : () -> Unit ): Double {
    val nanos = System . nanoTime ()
    body ()
    val elapsed = System . nanoTime () - nanos
    return elapsed . toDouble ()/1000000.0
}