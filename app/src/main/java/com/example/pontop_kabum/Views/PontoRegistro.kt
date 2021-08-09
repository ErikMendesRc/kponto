package com.example.pontop_kabum.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.pontop_kabum.R
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class PontoRegistro : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ponto_registro)

        val dataAtual = findViewById<TextView>(R.id.dataCounter)
        dataAtual.text = SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(Date())

        countTimer()
        registrarPonto()
        userInfo()
    }

    fun userInfo(){
        val userInfo = FirebaseAuth.getInstance().currentUser
        val nome = findViewById<TextView>(R.id.username)
        val foto = findViewById<ImageView>(R.id.photoUrl)

        nome.text = userInfo?.displayName

        val photoUrl = userInfo?.photoUrl.toString()
        Picasso.get().load(photoUrl).into(foto)
    }

    fun countTimer(){
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                updateTimer()
            }
        }, 0, 1000)
2
    }
    fun updateTimer() {
        runOnUiThread {
            val hoursCounter = findViewById<TextView>(R.id.hoursCounter)
            hoursCounter.text = SimpleDateFormat("hh:mm:ss", Locale.ROOT).format(Date())
        }
    }

    fun registrarPonto(){

        val registrar = findViewById<ImageButton>(R.id.registrarPonto)
        val registroEntrada = findViewById<TextView>(R.id.registroEntrada)
        val entradaAlmoco = findViewById<TextView>(R.id.entradaAlmoco)
        val saidaAlomoco = findViewById<TextView>(R.id.voltaAlmoco)
        val saida = findViewById<TextView>(R.id.saida)
        registrar.setOnClickListener(){
            count++

            if(count == 1){
                registroEntrada.text = SimpleDateFormat("'Entrada: 'hh:mm", Locale.ROOT)
                    .format(Date())
            }
            if(count == 2){
                entradaAlmoco.text = SimpleDateFormat("'Entrada Almoço: 'hh:mm", Locale.ROOT)
                    .format(Date())
            }
            if(count == 3){
                saidaAlomoco.text = SimpleDateFormat("'Saída Almoço: 'hh:mm", Locale.ROOT)
                    .format(Date())
            }
            if(count == 4){
                saida.text = SimpleDateFormat("'Saída: 'hh:mm", Locale.ROOT)
                    .format(Date())
            } else {
                !registroEntrada.isEnabled
            }
        }
    }
}

