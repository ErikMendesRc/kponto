package com.example.pontop_kabum.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pontop_kabum.R
import com.example.pontop_kabum.databinding.ActivityHistoricoPontoBinding


class HistoricoPonto : AppCompatActivity() {

    lateinit var binding: ActivityHistoricoPontoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoPontoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navBottomControl()
    }

    fun historicoPonto(): Boolean {
        intent = Intent(this, HistoricoPonto::class.java)
        startActivity(intent)
        finish()
        return true
    }

    fun ponto(): Boolean {
        intent = Intent(this, PontoRegistro::class.java)
        startActivity(intent)
        finish()
        return true
    }


    fun navBottomControl() {
        val bottomNav = binding.bottomNav
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_historico ->  historicoPonto()
                else -> ponto()
            }
        }
    }
}