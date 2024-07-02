package ru.itis.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.itis.homework2.databinding.FragmentBlankBinding
import ru.itis.homework2.databinding.FragmentFriendsBinding
import ru.itis.homework2.databinding.FragmentProfileBinding

class BlankFragment : Fragment(R.layout.fragment_blank) {
    private var binding: FragmentBlankBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlankBinding.bind(view)

        val email = arguments?.getString(ARG_EMAIL) ?: "ERROR"

        binding?.run {
            blankTitle.text = "${blankTitle.text}  $email"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_EMAIL = "ARG_EMAIL"
        private const val ARG_AGE = "ARG_AGE"

        fun bundle(email: String, age: Int): Bundle = Bundle().apply {
            putString(ARG_EMAIL, email)
            putInt(ARG_AGE, age)
        }
    }
}


