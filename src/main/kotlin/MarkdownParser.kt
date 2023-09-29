import java.io.BufferedReader
import java.io.FileReader

class MarkdownParser : CodeParser {
    // this will take in a filename
    // parse the code -- line by line --> reader.readLine()
    // every line is a Node
    // return the list of Nodes

    override fun parseCode(filename: String): List<Node> {
        val nodes = mutableListOf<Node>()
        val reader = BufferedReader(FileReader(filename))

        var line:String?
        while(reader.readLine().also {line = it} != null){
            line?.let{
                val regex0 = Regex("^(\\w.*)")
                if (regex0.matches(it)) {
                    val results = regex0.matchEntire(it)
                    println(results?.groups?.get(1)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(1)?.value, 0))
                }
                val regex1 = Regex("^# (.*)")
                if (regex1.matches(it)) {
                    val results = regex1.matchEntire(it)
                    println(results?.groups?.get(1)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(1)?.value, 1))
                }
                val regex2 = Regex("^## (.*)")
                if (regex2.matches(it)) {
                    val results = regex2.matchEntire(it)
                    println(results?.groups?.get(1)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(1)?.value, 2))
                }
                val regex3 = Regex("^### (.*)")
                if (regex3.matches(it)) {
                    val results = regex3.matchEntire(it)
                    println(results?.groups?.get(1)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(1)?.value, 3))
                }
                val regex4 = Regex("(^\\*\\*)(.*)\\*\\*")
                if (regex4.matches(it)) {
                    val results = regex4.matchEntire(it)
                    println(results?.groups?.get(2)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(2)?.value, 4))
                }
                val regex5 = Regex("(^\\*)(.*)\\*")
                if (regex5.matches(it)) {
                    val results = regex5.matchEntire(it)
                    println(results?.groups?.get(2)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(2)?.value, 5))
                }
                val regex6 = Regex("^>(.*)")
                if (regex6.matches(it)) {
                    val results = regex6.matchEntire(it)
                    println(results?.groups?.get(1)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(1)?.value, 6))
                }
                val regex7 = Regex("^---(.*)")
                if (regex7.matches(it)) {
                    val results = regex6.matchEntire(it)
                    println(results?.groups?.get(1)?.value)
                    nodes.add(MarkdownNode(results?.groups?.get(1)?.value, 7))
                }
            }
        }
        reader.close()
        return nodes
    }
}