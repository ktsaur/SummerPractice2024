package ru.itis.homework2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null
    private var sendTextButton: Button? = view?.findViewById(R.id.send_text_button)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding!!.sendTextButton.setOnClickListener {
            val emailText = binding!!.etEmail.text.toString()
            if (emailText.isEmpty()) {
                Snackbar.make(it, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_LONG).show()
            } else {
                val age = 10
                findNavController().navigate(
                    R.id.action_mainFragment_to_blankFragment2
                    //BlankFragment.bundle(email = emailText, age = age)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}