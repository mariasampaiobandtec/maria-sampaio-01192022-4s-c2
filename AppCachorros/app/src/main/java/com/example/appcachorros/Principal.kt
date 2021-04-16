package com.example.appcachorros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.atividade_principal)
    }

    fun cadastrarCachorro(view: View) {
        val tela2 = Intent(this, Tela2::class.java)

        startActivity(tela2)
    }


    fun listarCachorros(view: View) {
        val tela3 = Intent(this, Tela3::class.java)

        startActivity(tela3)
    }
}