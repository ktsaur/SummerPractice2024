package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.FragmentFriendsBinding

class FriendsFragment : Fragment(R.layout.fragment_friends) {
    private var binding: FragmentFriendsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFriendsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}