package com.praveenposwal.androidapp.data.repository

import com.praveenposwal.androidapp.common.Resource
import com.praveenposwal.androidapp.data.api.ApiService
import com.praveenposwal.androidapp.data.db.PostDao
import com.praveenposwal.androidapp.data.db.toEntity
import com.praveenposwal.androidapp.domain.model.Comment
import com.praveenposwal.androidapp.domain.model.Post
import com.praveenposwal.androidapp.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val postDao: PostDao
) : PostRepository {

    override fun getPosts(): Flow<Resource<List<Post>>> = flow {
        emit(Resource.Loading())
        
        // Emit local data first
        val localPosts = postDao.getPosts().map { entities ->
            entities.map { it.toDomain() }
        }
        
        // We can't easily emit Flow inside Flow builder like this for single value vs stream.
        // Better approach for offline-first with Resource:
        // 1. Emit Loading
        // 2. Try fetch from API & save to DB
        // 3. Emit Success (or Error) based on DB stream
        
        try {
            val remotePosts = apiService.getPosts()
            remotePosts.forEach { post ->
                val existingPost = postDao.getPostById(post.id)
                val isFavorite = existingPost?.isFavorite ?: false
                postDao.insertPost(post.toEntity().copy(isFavorite = isFavorite))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }

        // Emit local data stream
        postDao.getPosts().collect { entities ->
            emit(Resource.Success(entities.map { it.toDomain() }))
        }
    }

    override fun getComments(postId: Int): Flow<Resource<List<Comment>>> = flow {
        emit(Resource.Loading())
        try {
            val comments = apiService.getComments(postId)
            emit(Resource.Success(comments))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

    override fun getFavoritePosts(): Flow<List<Post>> {
        return postDao.getFavoritePosts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun refreshPosts() {
        try {
            val remotePosts = apiService.getPosts()
            // We need to preserve the favorite status of existing posts
            // This is a naive implementation. A better way would be to only update non-favorite fields or merge.
            // Or, since the API doesn't return favorite status, we assume false from API.
            // We should check if the post already exists and is favorite.
            
            remotePosts.forEach { post ->
                val existingPost = postDao.getPostById(post.id)
                val isFavorite = existingPost?.isFavorite ?: false
                postDao.insertPost(post.toEntity().copy(isFavorite = isFavorite))
            }
        } catch (e: Exception) {
            // Handle error or let it propagate. For offline first, we might just log it.
            e.printStackTrace()
        }
    }

    override suspend fun toggleFavorite(postId: Int, isFavorite: Boolean) {
        postDao.updateFavoriteStatus(postId, isFavorite)
    }
}
