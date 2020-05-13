package domain

class Posts(val posts: List<Post> = emptyList()): List<Post> by posts {
}
