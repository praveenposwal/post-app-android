package com.praveenposwal.androidapp.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.praveenposwal.androidapp.R
import com.praveenposwal.androidapp.databinding.FragmentFavoriteBinding
import com.praveenposwal.androidapp.ui.MainActivity
import com.praveenposwal.androidapp.ui.PostAdapter
import com.praveenposwal.androidapp.ui.postdetails.PostDetailsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoriteBinding.bind(view)

        val adapter = PostAdapter(
            onFavoriteClick = { post, isFavorite ->
                viewModel.onFavoriteClick(post, isFavorite)
            },
            onItemClick = { post ->
                (requireActivity() as MainActivity).navigateTo(PostDetailsFragment.newInstance(post))
            }
        )
        binding.rvFavorites.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.favoritePosts.collect { posts ->
                    adapter.submitList(posts)
                    if (posts.isEmpty()) {
                        binding.tvEmpty.visibility = View.VISIBLE
                        binding.rvFavorites.visibility = View.GONE
                    } else {
                        binding.tvEmpty.visibility = View.GONE
                        binding.rvFavorites.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
