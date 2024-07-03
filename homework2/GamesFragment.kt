package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.FragmentGamesBinding

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