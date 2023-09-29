class MarkdownNode(text: String?, val type: Int) : Node(text) {

    override fun toHTML(): String {
        if (type == 0) {
            return "$text"
        }
        if (type == 1) {
            return "<h1>$text</h1>"
        }
        if (type == 2) {
            return "<h2>$text</h2>"
        }
        if (type == 3) {
            return "<h3>$text</h3>"
        }
        if (type == 4) {
            return "<b>$text</b>"
        }
        if (type == 5) {
            return "<i>$text</i>"
        }
        if (type == 6) {
            return "<blockquote>$text</blockquote>"
        }
        if (type == 7) {
            return "<hr/>"
        }
        return ""
    }
}