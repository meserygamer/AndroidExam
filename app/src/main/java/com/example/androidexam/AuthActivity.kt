package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    var _binding : ActivityAuthBinding? = null; //Биндинг активности
    val binding : ActivityAuthBinding //Свойство для доступа к биндингу без постоянного прописывания _binding!!
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater); //Создаём биндинг
        setContentView(binding.root) //Открываем страницу на основе созданного биндинга
    }
}