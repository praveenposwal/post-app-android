package com.praveenposwal.androidapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.praveenposwal.androidapp.R
import com.praveenposwal.androidapp.databinding.FragmentHomeBinding
import com.praveenposwal.androidapp.ui.MainActivity
import com.praveenposwal.androidapp.ui.PostAdapter
import com.praveenposwal.androidapp.ui.postdetails.PostDetailsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)

        val adapter = PostAdapter(
            onFavoriteClick = { post, isFavorite ->
                viewModel.onFavoriteClick(post, isFavorite)
            },
            onItemClick = { post ->
                (requireActivity() as MainActivity).navigateTo(PostDetailsFragment.newInstance(post))
            }
        )
        binding.rvPosts.adapter = adapter
        
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.onSearchQueryChanged(newText ?: "")
                return true
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.searchQuery.collect { query ->
                        adapter.setSearchQuery(query)
                    }
                }
                launch {
                    viewModel.posts.collect { resource ->
                        when (resource) {
                            is com.praveenposwal.androidapp.common.Resource.Loading<*> -> {
                                binding.progressBar.visibility = View.VISIBLE
                            }
                            is com.praveenposwal.androidapp.common.Resource.Success<*> -> {
                                binding.progressBar.visibility = View.GONE
                                adapter.submitList(resource.data as List<com.praveenposwal.androidapp.domain.model.Post>?)
                            }
                            is com.praveenposwal.androidapp.common.Resource.Error<*> -> {
                                binding.progressBar.visibility = View.GONE
                                android.widget.Toast.makeText(requireContext(), resource.message, android.widget.Toast.LENGTH_LONG).show()
                                adapter.submitList(resource.data as List<com.praveenposwal.androidapp.domain.model.Post>?)
                            }
                        }
                    }
                }
            }
        }
    }
}
