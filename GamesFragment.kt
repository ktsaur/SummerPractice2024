package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.itis.homework2.databinding.FragmentFriendsBinding
import ru.itis.homework2.databinding.FragmentGamesBinding

class GamesFragment : Fragment(R.layout.fragment_games) {
    private var binding: FragmentGamesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGamesBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}