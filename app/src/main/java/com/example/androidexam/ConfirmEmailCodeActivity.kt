package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityAuthBinding
import com.example.androidexam.databinding.ActivityConfirmEmailCodeBinding

class ConfirmEmailCodeActivity : AppCompatActivity() {

    var _binding : ActivityConfirmEmailCodeBinding? = null;
    //Свойство для доступа к биндингу без постоянного прописывания _binding!!
    val binding : ActivityConfirmEmailCodeBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityConfirmEmailCodeBinding.inflate(layoutInflater); //Создаём биндинг
        setContentView(binding.root); //Открываем страницу на основе созданного биндинга
    }
}