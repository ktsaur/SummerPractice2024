package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.FragmentBlankBinding
import ru.itis.summerpractice24.databinding.FragmentMainBinding

class BlankFragment : Fragment(R.layout.fragment_blank) {
    private var binding: FragmentBlankBinding? = null
    private var adapter: MovieAdapter? = null
    //private var controller: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlankBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    private fun initAdapter() {
        binding?.run {
            adapter = MovieAdapter(list = MovieRepository.movies,
                glide = Glide.with(this@BlankFragment),
                onClick = {
                    // findNavController - получаем контроллер для работы с навигацией
                    findNavController().navigate( //запускаем экран и передаем туда данные
                        resId = R.id.action_blankFragment2_to_titanicFragment,
                        args = TitanicFragment.bundle(
                            name = ARG_NAME,
                            genre = ARG_GENRE
                        )
                    )
                }
            )
            rvCity.adapter = adapter
            rvCity.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_GENRE = "ARG_GENRE"
        fun bundle(name: String, genre: String): Bundle = Bundle().apply {
            putString(ARG_NAME, name)
            putString(ARG_GENRE, genre)
        }
    }
}


