package A

import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { tempReader ->
        println(tempReader.readText())
    }
}
