package ru.itis.homework2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.itis.homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }


        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }
    }

    override fun onBackPressed() { //срабатывает в тот момент, когда пользователь делает жест назад или
        super.onBackPressed()
        controller?.navigateUp() //навигация вперед. мы хотим, чтобы когда кнопка нажимается, мы возвращались назад
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}