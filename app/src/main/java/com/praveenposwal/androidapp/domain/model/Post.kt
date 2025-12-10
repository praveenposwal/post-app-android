package com.praveenposwal.androidapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val image: String,
    val userId: Int,
    val isFavorite: Boolean = false
) : Parcelable
