package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.androidexam.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity(){

    //Биндинг активности
    var _binding : ActivityAuthBinding? = null;
    //Свойство для доступа к биндингу без постоянного прописывания _binding!!
    val binding : ActivityAuthBinding
        get() = _binding!!

    //Свойство для переключения состояния кнопки с включенного на выключенное и наоборот
    var isNextButtonEnable : Boolean
        get() = binding.AuthActivityNextButton.isEnabled
        set(value) {
            binding.AuthActivityNextButton.isEnabled = value;
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater); //Создаём биндинг
        SetEmailFieldTextWatcher(); //Установка слушателя на поле ввода email
        SetNextButtonListner(); //Установка слушателя на нажатие кнопки
        setContentView(binding.root); //Открываем страницу на основе созданного биндинга
    }

    //Метод устанавливающий слушателя на поле ввода email
    private fun SetEmailFieldTextWatcher() {
        binding.AuthActivityEmailField
               .addTextChangedListener(object : TextWatcher{

                   override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                   override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                   //Вызывается после изменения поля email
                   override fun afterTextChanged(p0: Editable?) {
                       if(p0 == null) return; //Если p0 = null то выходим
                       isNextButtonEnable = Regex(
                           "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
                           .containsMatchIn(p0!!.toString()) //Задаем состояние кнопки в зависимости от того был ли введен email
                   }
               });
    //Создаем анонимный слушатель изменения текста для прослушивания изменения поля ввода email
    }

    //Метод устанавливающий слушателя на нажатие кнопки
    private fun SetNextButtonListner() {
        binding.AuthActivityNextButton.setOnClickListener(object : View.OnClickListener {

            //Происходит после нажатия на кнопку отправки кода
            override fun onClick(p0: View?) {
                startActivity(Intent(this@AuthActivity, ConfirmEmailCodeActivity::class.java));
            }

        }) //Создаем ананимный слушатель кликов и ставим его для прослушивания кнопки
    }
}