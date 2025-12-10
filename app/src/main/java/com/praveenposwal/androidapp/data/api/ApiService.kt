package com.praveenposwal.androidapp.data.api

import com.praveenposwal.androidapp.domain.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{postId}/comments")
    suspend fun getComments(@retrofit2.http.Path("postId") postId: Int): List<com.praveenposwal.androidapp.domain.model.Comment>
}
