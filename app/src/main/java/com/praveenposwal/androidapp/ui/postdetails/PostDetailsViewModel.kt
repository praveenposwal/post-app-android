package com.praveenposwal.androidapp.ui.postdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.praveenposwal.androidapp.common.Resource
import com.praveenposwal.androidapp.domain.model.Comment
import com.praveenposwal.androidapp.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _comments = MutableStateFlow<Resource<List<Comment>>>(Resource.Loading())
    val comments: StateFlow<Resource<List<Comment>>> = _comments

    fun getComments(postId: Int) {
        viewModelScope.launch {
            repository.getComments(postId).collect {
                _comments.value = it
            }
        }
    }
}
