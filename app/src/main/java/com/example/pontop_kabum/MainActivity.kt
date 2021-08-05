package com.example.pontop_kabum

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pontop_kabum.Views.PontoRegistro
import com.example.pontop_kabum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {

            //TODO: COLOCAR PARA MUDAR ACTIVITY SOMENTE SE O LOGIN FOR VÁLIDADO

            val intent = Intent(this, PontoRegistro::class.java)
            startActivity(intent)
        }
    }

}