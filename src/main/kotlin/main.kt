import java.io.File
import javax.print.attribute.IntegerSyntax
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.experimental.*

/**
 * Return url between "". Url must contain a single '.' to be valid.
 */
fun getUrl(s: String): String? {
    val regex = "([^\"]*)([\\.])([^\"]*)".toRegex()
    return regex.find(s)?.value.toString().toLowerCase()
}

fun main(args: Array<String>) {
    val urlList = mutableListOf<String>()
    val results = HashMap<String, Int>()
    val MAX_NUMBER_REQUESTS = 20

    // read urls from text file
    File("./src/main/resources/urls.txt").useLines { lines -> lines.forEach {
        val url = getUrl(it)
        if (url != null) {
            urlList.add(url)
            results.put(url, 0)
        }
    }}

    println(results)


    var counter = 0
    val numberOfThreads = 1_000_000

    val time = measureTimeMillis {
        for (i in 1..numberOfThreads) {
            thread() {
                counter += 1
            }
        }
    }

    println("${numberOfThreads} threads in ${time}ms.")

//    urlList.forEach {
//        println("> " + it)
//    }

    // concurrently fetch urls and update map if match is found

    // return subset of map - get entrySet() and streams -> filter where value > 0

}
