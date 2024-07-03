package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}