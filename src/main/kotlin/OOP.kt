// Data-класс Post
data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    var text: String = "text",
    val postType: String = "post",
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val comments: CommentsInfo = CommentsInfo(0),
    val likes: LikesInfo = LikesInfo()
)

// класс описания комментариев к посту
class CommentsInfo (
    var count: Int = 0,
    var canPost: Boolean = true,
    var groupsCanPost: Boolean = false,
    var canClose: Boolean = false,
    var canOpen: Boolean = false
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommentsInfo

        if (count != other.count) return false
        if (canPost != other.canPost) return false
        if (groupsCanPost != other.groupsCanPost) return false
        if (canClose != other.canClose) return false
        if (canOpen != other.canOpen) return false

        return true
    }

    override fun hashCode(): Int {
        var result = count
        result = 31 * result + canPost.hashCode()
        result = 31 * result + groupsCanPost.hashCode()
        result = 31 * result + canClose.hashCode()
        result = 31 * result + canOpen.hashCode()
        return result
    }
}

// класс описания лайков к посту
class LikesInfo {
    var count: Int = 0
    var userLikes: Boolean = true
    var canLike: Boolean = true
    var canPublish: Boolean = true
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LikesInfo

        if (count != other.count) return false
        if (userLikes != other.userLikes) return false
        if (canLike != other.canLike) return false
        if (canPublish != other.canPublish) return false

        return true
    }

    override fun hashCode(): Int {
        var result = count
        result = 31 * result + userLikes.hashCode()
        result = 31 * result + canLike.hashCode()
        result = 31 * result + canPublish.hashCode()
        return result
    }
}

fun main() {
    WallService.add(Post(text = "Привет Вася"))
    WallService.add(Post(text = "Привет Дима"))
    WallService.add(Post(text = "Привет Коля"))
    WallService.add(Post(text = "Купил новую квартиру"))

    WallService.print()
    val post1 = Post(2,text = "ХаХаХа")
    WallService.update(post1)
    WallService.print()

    post1.text = "Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww"
    println(post1)
    WallService.print()
}