package com.praveenposwal.androidapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.praveenposwal.androidapp.domain.model.Post

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val body: String,
    val image: String,
    val userId: Int,
    val isFavorite: Boolean = false
) {
    fun toDomain(): Post {
        return Post(id, title, body, image, userId, isFavorite)
    }
}

fun Post.toEntity(): PostEntity {
    return PostEntity(id, title, body, image, userId, isFavorite)
}
