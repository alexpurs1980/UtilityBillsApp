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
            var dateOfCalc = binding.editTextTextDateOfCalc?.text.toString()

//            // TARIFFS 01/06/2022
//            val kWh = 6.11
//            val hotCubeMeter = 223.04
//            val coldCubeMeter = 45.88
//            val gasFixPrice = gasPrice

            // TARIFFS 01/12/2022
            val kWh = 6.43
            val hotCubeMeter = 243.16
            val coldCubeMeter = 50.93
            val gasFixPrice = gasPrice


            val electricySum = "\nЭлектричество ${electricyNow - electricyLast} кВт х ${kWh} руб. = ${(electricyNow - electricyLast) * kWh} руб."
            val hotWaterSum = "\nГорячая вода ${hotWaterNow - hotWaterLast} куб.м х ${hotCubeMeter} руб. = ${(hotWaterNow - hotWaterLast) * hotCubeMeter} руб."
            val coldWaterSum = "\nХолодная вода ${coldWaterNow - coldWaterLast} куб.м х ${coldCubeMeter} руб. = ${(coldWaterNow - coldWaterLast) * coldCubeMeter} руб."
            val gasSum = "\nГаз ${gasPrice} руб."
            val totalSum = "\nИтого за месяц ${((electricyNow - electricyLast) * kWh) + ((hotWaterNow - hotWaterLast) * hotCubeMeter) + ((coldWaterNow - coldWaterLast) * coldCubeMeter) + gasFixPrice} руб."
//            val dateToPay = "\nТарифы по состоянию на 1 июля 2022 г."
            val dateToPay = "\nТарифы по состоянию на 1 декабря 2022 г."
            dateOfCalc = "Дата расчета: " + dateOfCalc


            //выводим результат (поле принимает только строку - перевод в Стринг)
            binding.resultTextView.setVisibility(View.VISIBLE)
            binding.resultTextView.text = dateOfCalc + dateToPay+ electricySum + hotWaterSum + coldWaterSum + gasSum + totalSum

        }


    }

}

