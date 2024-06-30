package ru.itis.summerpractice2024

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.itis.summerpractice2024.databinding.ActivityMainBinding
import java.util.Scanner
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    private var sendTextButton: Button? = null;

    private var viewBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //при помощи вызова этого метода происходит связь нашего кода с тем, что мы наверстали
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        initViewsModern()

    }



    private fun initViewsModern() {
        viewBinding?.let { binding ->
            this.sendTextButton = findViewById(R.id.send_text_btn)
            sendTextButton?.setOnClickListener {
                var counter = binding.emailEt.text.toString().toInt()
                Log.i("test", "В гонке учавствует ${counter} машин")
                var avto = List(counter) { buildRandomAvto() }
                var activeAvto = avto.toMutableList()

                while (activeAvto.size > 1) {
                    var couple = activeAvto.shuffled().chunked(2);
                    var winners = mutableListOf<Automobile>()

                    couple.forEach { couple ->
                        if (couple.size < 2) {
                            Log.i("test", "${couple.first().model} - Нет пары, следующий круг")
                            winners.add(couple.first())
                        } else {
                            var winner = avtoСomparison(couple[0], couple[1])
                            Log.i("test", "--- Гонка между ${couple[0].model} и ${couple[1].model}, Победитель ${winner.model}")
                            winners.add(winner)
                        }
                    }
                    activeAvto = winners
                }
                Log.i("test", "Победитель гонок:${activeAvto.first().model}")
            }
        }

    }



    open class Automobile(
        val mark: String,
        val model: String,
        val year: Int,
        val color: String,
        val mileage: Int
    ) {

        open fun infoAboutAvto() {
            println("Марка: $mark, Модель: $model, Год выпуска: $year, Цвет: $color, Цена: $mileage")
        }
    }


    class Crossover(
        mark: String,
        model: String,
        year: Int,
        color: String,
        mileage: Int,
        val typePrivod: String,
        val enginePower: Int
    ) : Automobile(mark, model, year, color, mileage) {
        override fun infoAboutAvto() {
            super.infoAboutAvto()
            println("Тип привода: $typePrivod, Мощность двигателя: $enginePower л/100км.")
        }
    }

    class SportCar(
        mark: String,
        model: String,
        year: Int,
        color: String,
        mileage: Int,
        val maxSpeed: Int,
    ) : Automobile(mark, model, year, color, mileage) {
        override fun infoAboutAvto() {
            super.infoAboutAvto()
            println("Максимальная скорость: $maxSpeed")
        }
    }

    class Hatchback(
        mark: String,
        model: String,
        year: Int,
        color: String,
        mileage: Int,
        val typeFuel: String,
        val consumptionFuel: Double
    ) : Automobile(mark, model, year, color, mileage) {
        override fun infoAboutAvto() {
            super.infoAboutAvto()
            println("Тип топлива: $typeFuel, Расход топлива: $consumptionFuel л/100км.")
        }
    }

    class Sedan(
        mark: String,
        model: String,
        year: Int,
        color: String,
        mileage: Int,
        val trunkVolume: Int,
        val comfortLevel: Int
    ) : Automobile(mark, model, year, color, mileage) {
        override fun infoAboutAvto() {
            super.infoAboutAvto()
            println("Объем багажника: $trunkVolume л, Уровень комфорта: $comfortLevel")
        }
    }


    //Функ Строитель для Автомобиля
    private fun buildRandomAvto(): Automobile {
        val marks = listOf("Toyota", "Honda", "Ford", "BMW")
        val models = listOf("Camry", "Accord", "Focus", "3 Series")
        val colors = listOf("Синий", "Красный", "Черный", "Серебристый")

        val mark = marks.random()
        val model = models.random()
        val year = Random.nextInt(2010, 2023)
        val color = colors.random()
        val mileage = Random.nextInt(1000, 50000)

        return Automobile(mark, model, year, color, mileage)
    }

    private fun avtoСomparison(avto1: Automobile, avto2: Automobile): Automobile {
        val winAvto = if (avto1.mileage < avto2.mileage) avto1 else avto2
        return winAvto
    }
}