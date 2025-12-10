package com.praveenposwal.androidapp.ui.settings

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.praveenposwal.androidapp.R

public class SettingsFragmentDirections private constructor() {
  public companion object {
    public fun actionSettingsFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingsFragment_to_loginFragment)
  }
}
