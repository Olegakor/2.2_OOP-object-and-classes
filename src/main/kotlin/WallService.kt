// Объект WallService для хранения постов в массиве.
object WallService {
    private var posts = emptyArray<Post>()
    private var idPost = 0

    // метод создания новой записи
    fun add(post: Post): Post {
        posts += post.copy(id = ++idPost)
        return posts.last()
    }

    // метод обновления записи
    fun update(post: Post): Boolean {
        for ((index, elem) in posts.withIndex()) {
            if (elem.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    // метод для показа всех записей
    fun print () {
        for (element in posts) {
            println(element)
        }
    }

    // метод очистки массива записей и обнуления id
    fun clear() {
        posts = emptyArray()
        idPost = 0
    }
}