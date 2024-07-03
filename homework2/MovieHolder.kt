package ru.itis.homework2

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice24.R
import ru.itis.summerpractice24.databinding.ItemMoviesBinding


//В ситиХолдер мы работаем только с одной ячейкой
class MovieHolder(
    private val binding: ItemMoviesBinding,
    private val glide: RequestManager,
    private val onClick: (Movie) -> Unit,
) : ViewHolder(binding.root) {

    //функция онБайнд, в которую приходит только одна ячейка. Метод достает данные
    fun onBind(movie: Movie) {
        binding.run {
            tvMovie.text  = movie.name
            tvGenre.text = movie.genre

            Glide.with(itemView.context)
                .load(movie.url)
                .error(R.drawable.not_found_24)
                .placeholder(R.drawable.not_found_24)
                .into(ivImage)

            root.setOnClickListener{
                onClick.invoke(movie)
            }
        }
    }
}