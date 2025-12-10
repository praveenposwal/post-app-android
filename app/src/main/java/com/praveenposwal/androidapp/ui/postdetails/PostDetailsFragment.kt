package com.praveenposwal.androidapp.ui.postdetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.praveenposwal.androidapp.R
import com.praveenposwal.androidapp.common.Resource
import com.praveenposwal.androidapp.databinding.FragmentPostDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostDetailsFragment : Fragment(R.layout.fragment_post_details) {

    private val viewModel: PostDetailsViewModel by viewModels()
    private val args: PostDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentPostDetailsBinding
    private lateinit var commentAdapter: CommentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostDetailsBinding.bind(view)

        setupUI()
        observeComments()
        
        viewModel.getComments(args.post.id)
    }

    private fun setupUI() {
        val post = args.post
        binding.tvTitle.text = post.title
        binding.tvBody.text = post.body

        commentAdapter = CommentAdapter()
        binding.rvComments.adapter = commentAdapter
    }

    private fun observeComments() {
        lifecycleScope.launch {
            viewModel.comments.collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.tvError.visibility = View.GONE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.GONE
                        commentAdapter.submitList(resource.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = resource.message
                        Toast.makeText(requireContext(), resource.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
