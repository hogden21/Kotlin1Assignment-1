open class Node(val text:String?) {

    open fun toHTML(): String {
        return "$text"
    }
}