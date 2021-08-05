package com.example.pontop_kabum.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pontop_kabum.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class PontoRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ponto_registro)
        countTimer()
        registrarPonto()

    }

    fun countTimer(){
        val timer = Timer()
        timer?.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                updateTimer()
            }
        }, 0, 1000)

    }
    fun updateTimer() {
        runOnUiThread {
            val hoursCounter = findViewById<TextView>(R.id.hoursCounter)
            hoursCounter.text = SimpleDateFormat("hh:mm:ss", Locale.ROOT).format(Date())
        }
    }

    fun registrarPonto(){

        //TODO: COLOCAR CONTADOR PARA IDENTIFICAR QUAIS OS PONTOS ESTÃO SENDO BATIDOS

        val registrar = findViewById<Button>(R.id.registrarPonto)
        val registroEntrada = findViewById<TextView>(R.id.registroEntrada)
        registrar.setOnClickListener(){
            registroEntrada.text = SimpleDateFormat("'Entrada: 'hh:mm", Locale.ROOT).format(Date())
        }
    }
}

