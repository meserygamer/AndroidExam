package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
        SetEmailCodeListner() //Устанавливаем слушателя на PinView
        SetBackButtonOnClickListner() //Устанавливаем слушателя на клик по кнопке назад
        setContentView(binding.root); //Открываем страницу на основе созданного биндинга
        _timer.start() //Стартуем таймер
    }

    //Функция для установки слушателя на поле ввода кода
    private fun SetEmailCodeListner() {
        binding.ConfirmEmailCodeActivityInputEmailCodeField
            .addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                //Вызывается после изменения текста в PinView
                override fun afterTextChanged(p0: Editable?) {
                    if(p0 == null) return; //Если текст в PinView null то выходим
                    if(p0.toString().length == 4) //Если длина текста в PinView равна 4 (длина кода отправляемого на Email), отправляем на проверку
                    {

                    }
                }
            }) //Создаем анонимный слушатель изменений текста и ставим его на PinView
    }

    //Функция для установки слушателя на кнопку назад
    private fun SetBackButtonOnClickListner(){
        binding.ConfirmEmailCodeActivityBackButton.setOnClickListener(object : View.OnClickListener{

            //Вызывается при клике на кнопку назад
            override fun onClick(p0: View?) {
                var previousIntent = Intent(this@ConfirmEmailCodeActivity
                    , AuthActivity::class.java); //Создаем Intent для возврата к вводу Email
                previousIntent
                    .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT) //Добавляем флаг для открытия
                    //Прошлого варианта окна, а не создания нового
                startActivity(previousIntent); //Переходим на предыдущую активность
            }

        }) //Создаем анонимный слушатель кликов кнопки и ставим его на кнопку назад
    }
}