package com.praveenposwal.androidapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.praveenposwal.androidapp.databinding.ItemPostBinding
import com.praveenposwal.androidapp.domain.model.Post

class PostAdapter(
    private val onFavoriteClick: (Post, Boolean) -> Unit,
    private val onItemClick: (Post) -> Unit
) : ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private var searchQuery: String = ""

    fun setSearchQuery(query: String) {
        searchQuery = query
        notifyDataSetChanged()
    }

    inner class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.tvTitle.text = highlightText(post.title, searchQuery)
            binding.tvBody.text = highlightText(post.body, searchQuery)
            binding.btnFavorite.isChecked = post.isFavorite

            Glide.with(binding.root.context)
                .load(post.image)
                .into(binding.ivPostImage)

            binding.btnFavorite.setOnClickListener {
                onFavoriteClick(post, binding.btnFavorite.isChecked)
            }
            
            binding.root.setOnClickListener {
                onItemClick(post)
            }
        }

        private fun highlightText(text: String, query: String): CharSequence {
            if (query.isBlank()) return text
            val spannable = android.text.SpannableString(text)
            val pattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(query), java.util.regex.Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(text)
            while (matcher.find()) {
                spannable.setSpan(
                    android.text.style.BackgroundColorSpan(android.graphics.Color.YELLOW),
                    matcher.start(),
                    matcher.end(),
                    android.text.Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            return spannable
        }
    }

    class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
}
