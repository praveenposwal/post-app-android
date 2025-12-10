package com.praveenposwal.androidapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    fun getPosts(): Flow<List<PostEntity>>

    @Query("SELECT * FROM posts WHERE isFavorite = 1")
    fun getFavoritePosts(): Flow<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPosts(posts: List<PostEntity>)

    @Query("UPDATE posts SET isFavorite = :isFavorite WHERE id = :postId")
    suspend fun updateFavoriteStatus(postId: Int, isFavorite: Boolean)

    @Query("DELETE FROM posts")
    suspend fun clearPosts()
    
    @Query("SELECT * FROM posts WHERE id = :id")
    suspend fun getPostById(id: Int): PostEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostEntity)
}
