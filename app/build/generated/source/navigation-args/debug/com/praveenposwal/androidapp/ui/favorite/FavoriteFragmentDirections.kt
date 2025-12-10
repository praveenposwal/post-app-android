package com.praveenposwal.androidapp.ui.favorite

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.praveenposwal.androidapp.R
import com.praveenposwal.androidapp.domain.model.Post
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FavoriteFragmentDirections private constructor() {
  private data class ActionFavoriteFragmentToPostDetailsFragment(
    public val post: Post,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_favoriteFragment_to_postDetailsFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Post::class.java)) {
          result.putParcelable("post", this.post as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Post::class.java)) {
          result.putSerializable("post", this.post as Serializable)
        } else {
          throw UnsupportedOperationException(Post::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionFavoriteFragmentToPostDetailsFragment(post: Post): NavDirections =
        ActionFavoriteFragmentToPostDetailsFragment(post)
  }
}
