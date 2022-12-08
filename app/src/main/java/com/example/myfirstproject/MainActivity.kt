package com.example.myfirstproject

import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myfirstproject.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {



    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //точка входа в приложение, отсюда можно писать приложение


        //слушаем нажатие на кнопку через метод



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

            //вычисление (работа с данными) - тарифы на 1 июля 2022 г.
            // кВт час = 6,17 руб.
            // горячая вода = 223,04 руб.
            // холодная вода = 45,88 руб.
            // газ = 60 руб.
            val electricySum = "Электричество ${electricyNow - electricyLast} кВт х 6,17 руб. = ${(electricyNow - electricyLast) * 6.17} руб."
            val hotWaterSum = "\nГорячая вода ${hotWaterNow - hotWaterLast} куб.м х 223,04 руб. = ${(hotWaterNow - hotWaterLast) * 223.04} руб."
            val coldWaterSum = "\nХолодная вода ${coldWaterNow - coldWaterLast} куб.м х 45,88 руб. = ${(coldWaterNow - coldWaterLast) * 45.88} руб."
            val gasSum = "\nГаз ${gasPrice} руб."
            val totalSum = "\nИтого за месяц ${((electricyNow - electricyLast) * 6.17) + ((hotWaterNow - hotWaterLast) * 223.04) + ((coldWaterNow - coldWaterLast) * 45.88) + 60} руб."
            val dateToPay = "Тарифы по состоянию на 1 июля 2022 г."


            //выводим результат (поле принимает только строку - перевод в Стринг)
            binding.resultTextView.setVisibility(View.VISIBLE)
            binding.resultTextView.text = electricySum + hotWaterSum + coldWaterSum + gasSum + totalSum

        }


    }

}

