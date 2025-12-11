package com.praveenposwal.androidapp.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.praveenposwal.androidapp.R
import com.praveenposwal.androidapp.databinding.FragmentSettingsBinding
import com.praveenposwal.androidapp.ui.MainActivity
import com.praveenposwal.androidapp.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val viewModel: SettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSettingsBinding.bind(view)

        binding.btnLogout.setOnClickListener {
            viewModel.logout()
            (requireActivity() as MainActivity).navigateTo(LoginFragment(), addToBackStack = false)
        }
    }
}
