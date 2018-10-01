import java.io.File
import java.io.InputStream
import java.util.regex.Matcher
import java.util.regex.Pattern

fun getUrl(s: String): String? {
    val regex = "\"([^\"]*)([\\.])([^\"]*)\"".toRegex()
    return regex.find(s)?.value
}

fun main(args: Array<String>) {
    val urlList = mutableListOf<String>()



    // @TODO make readFile() method to store each url into hashmap
    File("./src/main/resources/urls.txt").useLines { lines -> lines.forEach {
        val url = getUrl(it)
        if (url != null) {
            urlList.add(url)
        }
    }}

    urlList.forEach {
        println("> " + it)
    }

    // concurrently fetch urls and update map if match is found

    // return subset of map - get entrySet() and streams -> filter

}