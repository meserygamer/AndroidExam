package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.androidexam.databinding.ActivityAuthBinding
import com.example.androidexam.databinding.ActivityConfirmEmailCodeBinding

class ConfirmEmailCodeActivity : AppCompatActivity() {

    //Создание анонимного объекта типа таймер на 60 секунд с тиком каждую секунду
    val _timer = object : CountDownTimer(60000, 1000) {

        //Вызывается при каждом тике таймера (в нашем случае каждую секунду)
        override fun onTick(millisUntilFinished: Long) {
            binding.ConfirmEmailCodeActivityTimer.text = "Отправить код поторно можно\nбудет через " + millisUntilFinished / 1000 + " секунд"
        }

        //Вызывается после завершения работы таймера
        override fun onFinish() {
            binding.ConfirmEmailCodeActivityTimer.text = "Код был отправлен повторно!"
        }
    }

    var _binding : ActivityConfirmEmailCodeBinding? = null;
    //Свойство для доступа к биндингу без постоянного прописывания _binding!!
    val binding : ActivityConfirmEmailCodeBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityConfirmEmailCodeBinding.inflate(layoutInflater); //Создаём биндинг
        setContentView(binding.root); //Открываем страницу на основе созданного биндинга
        _timer.start() //Стартуем таймер
    }
}