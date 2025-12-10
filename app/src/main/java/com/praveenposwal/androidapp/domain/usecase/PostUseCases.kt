package com.praveenposwal.androidapp.domain.usecase

import com.praveenposwal.androidapp.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke() = repository.getPosts()
}

class GetFavoritePostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke() = repository.getFavoritePosts()
}

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(postId: Int, isFavorite: Boolean) = repository.toggleFavorite(postId, isFavorite)
}

class RefreshPostsUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke() = repository.refreshPosts()
}
