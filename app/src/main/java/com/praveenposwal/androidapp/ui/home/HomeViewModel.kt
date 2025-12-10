package com.praveenposwal.androidapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praveenposwal.androidapp.common.Resource
import com.praveenposwal.androidapp.domain.model.Post
import com.praveenposwal.androidapp.domain.usecase.GetPostsUseCase
import com.praveenposwal.androidapp.domain.usecase.RefreshPostsUseCase
import com.praveenposwal.androidapp.domain.usecase.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPostsUseCase: GetPostsUseCase,
    private val refreshPostsUseCase: RefreshPostsUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {

    private val _searchQuery = kotlinx.coroutines.flow.MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    val posts = combine(
        getPostsUseCase(),
        _searchQuery
            .debounce(500L)
            .distinctUntilChanged()
    ) { resource: Resource<List<Post>>, query: String ->
        if (query.isBlank()) {
            resource
        } else {
            when (resource) {
                is Resource.Success -> {
                    val filtered = resource.data?.filter {
                        it.title.contains(query as CharSequence, ignoreCase = true) || it.body.contains(query as CharSequence, ignoreCase = true)
                    }
                    Resource.Success(filtered ?: emptyList())
                }
                else -> resource
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Resource.Loading())

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    init {
        refreshPosts()
    }

    private fun refreshPosts() {
        viewModelScope.launch {
            refreshPostsUseCase()
        }
    }

    fun onFavoriteClick(post: Post, isFavorite: Boolean) {
        viewModelScope.launch {
            toggleFavoriteUseCase(post.id, isFavorite)
        }
    }
}
