// Julia Gersey & Hannah Ogden
// CSC-411 Markdown Parser Assignment


fun main(args: Array<String>) {
    // create MarkdownParser
    // pass it the input file
    // create corresponding HTML file by iterating through Nodes that parseCode() returned
    // call toHTML() to get the HTML representation
    // write the String to the file
    val markdownParser = MarkdownParser()
    val nodes = markdownParser.parseCode("input.md")

    for (node in nodes) {
        println(node.toHTML())
    }
}