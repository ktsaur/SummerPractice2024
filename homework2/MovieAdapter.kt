package ru.itis.homework2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.FragmentMainBinding
import ru.itis.summerpractice24.databinding.ItemMoviesBinding
import kotlin.coroutines.coroutineContext

class MovieAdapter(
    private val list: List<Movie>,
    private val glide: RequestManager,
    private val onClick: (Movie) -> Unit,
): RecyclerView.Adapter<MovieHolder> () {

    //метод вызывается в тот момент, когда мы в первый раз обращаемся к адаптеру
    //он создает те ячейки, которые нам понадобятся
    //вызывается один раз, и в этот единственный раз мы инициализируем какое-то количество newHolders которое нам понадобятся
    //другими словами, это метод, в котоорм мы описываем как задавать CityHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            binding = ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onClick = onClick,
        )
    }

    //вызывается каждый раз при скролле
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.onBind(list[position])
    }

    //даем понять сколько элементов в списке
    override fun getItemCount(): Int = list.size
}

