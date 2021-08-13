package com.example.pontop_kabum.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.pontop_kabum.R
import com.example.pontop_kabum.databinding.ActivityMainBinding
import com.example.pontop_kabum.databinding.ActivityPontoRegistroBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class PontoRegistro : AppCompatActivity() {
    var count = 0
    private lateinit var binding: ActivityPontoRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPontoRegistroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dataAtual = binding.dataCounter
        dataAtual.text = SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(Date())

        countTimer()
        registrarPonto()
        userInfo()
        navBottomControl()
    }

    fun userInfo(){
        val userInfo = FirebaseAuth.getInstance().currentUser
        val nome = binding.username
        val foto = binding.photoUrl

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
            val hoursCounter = binding.hoursCounter
            hoursCounter.text = SimpleDateFormat("hh:mm:ss", Locale.ROOT).format(Date())
        }
    }

    fun registrarPonto(){

        val registrar = binding.registrarPonto
        val registroEntrada = binding.registroEntrada
        val entradaAlmoco = binding.entradaAlmoco
        val saidaAlomoco = binding.voltaAlmoco
        val saida = binding.saida
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





