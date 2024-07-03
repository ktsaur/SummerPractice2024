package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.FragmentTitanicBinding


class TitanicFragment : Fragment(R.layout.fragment_titanic) {
    private var binding: FragmentTitanicBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTitanicBinding.bind(view)
        val button: Button = view.findViewById(R.id.send_text_but)
        button.setOnClickListener {
            findNavController().popBackStack()
        }
//        val name = arguments?.getInt(ARG_NAME) ?: "ERROR"
//        val genre = arguments?.getInt(ARG_GENRE) ?: "ERROR"
        val model = MovieRepository.movies.find {
            id == requireArguments().getInt(ARG_NAME)
        }
        with(binding) {
            if (model != null) {
                this?.textView2?.text = model.text
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
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
