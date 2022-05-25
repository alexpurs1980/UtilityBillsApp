package com.example.myfirstproject

import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstproject.databinding.ActivityMainBinding
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //точка входа в приложение, отсюда можно писать приложение

        //слушаем нажатие на кнопку через метод
        binding.calcSumButton.setOnClickListener {
            //пишем код по нажатию на кнопку - получаем содержимое окон и вычисляем их произведение

            //ввод данных
            val electricyLast = binding.electricyLastEditText.text.toString().toInt()
            val electricyNow = binding.electricyNowEditText.text.toString().toInt()
            val hotWaterLast = binding.hotWaterLastEditText.text.toString().toInt()
            val hotWaterNow = binding.hotWaterNowEditText.text.toString().toInt()
            val coldWaterLast = binding.coldWaterLastEditText.text.toString().toInt()
            val coldWaterNow = binding.coldWaterNowEditText.text.toString().toInt()
            val gasPrice = binding.gasEditText.text.toString().toInt()

            //вычисление (работа с данными)
            // кВт час = 5,92 руб.
            // горячая вода = 211,67 руб.
            // холодная вода = 43,57 руб.
            // газ = 60 руб.
            val electricySum = "Электричество ${electricyNow - electricyLast} кВт х 5,92 руб. = ${(electricyNow - electricyLast) * 5.92} руб."
            val hotWaterSum = "\nГорячая вода ${hotWaterNow - hotWaterLast} куб.м х 211,67 руб. = ${(hotWaterNow - hotWaterLast) * 211.67} руб."
            val coldWaterSum = "\nХолодная вода ${coldWaterNow - coldWaterLast} куб.м х 43,57 руб. = ${(coldWaterNow - coldWaterLast) * 43.57} руб."
            val gasSum = "\nГаз ${gasPrice} руб."
            val totalSum = "\nИтого за месяц ${((electricyNow - electricyLast) * 5.92) + ((hotWaterNow - hotWaterLast) * 211.67) + ((coldWaterNow - coldWaterLast) * 43.57) + 60} руб."


            //выводим результат (поле принимает только строку - перевод в Стринг)
            binding.resultTextView.text = electricySum + hotWaterSum + coldWaterSum + gasSum + totalSum

        }


    }
}