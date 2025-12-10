package com.praveenposwal.androidapp.domain.repository

import com.praveenposwal.androidapp.common.Resource
import com.praveenposwal.androidapp.domain.model.Comment
import com.praveenposwal.androidapp.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<Resource<List<Post>>>
    fun getComments(postId: Int): Flow<Resource<List<Comment>>>
    fun getFavoritePosts(): Flow<List<Post>>
    suspend fun refreshPosts()
    suspend fun toggleFavorite(postId: Int, isFavorite: Boolean)
}
