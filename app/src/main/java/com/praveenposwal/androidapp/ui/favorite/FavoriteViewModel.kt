package com.praveenposwal.androidapp.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praveenposwal.androidapp.domain.model.Post
import com.praveenposwal.androidapp.domain.usecase.GetFavoritePostsUseCase
import com.praveenposwal.androidapp.domain.usecase.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    getFavoritePostsUseCase: GetFavoritePostsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    val favoritePosts = getFavoritePostsUseCase()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun onFavoriteClick(post: Post, isFavorite: Boolean) {
        viewModelScope.launch {
            toggleFavoriteUseCase(post.id, isFavorite)
        }
    }
}
