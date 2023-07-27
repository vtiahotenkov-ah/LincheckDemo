import java.util.LinkedList

class NaiveConcurrentDataStructure<T> {

    private val list = LinkedList<T>()

    fun save(t: T) {
        list.add(t)
    }

    fun remove(t: T) {
        list.remove(t)
    }

    fun count() = list.size
}