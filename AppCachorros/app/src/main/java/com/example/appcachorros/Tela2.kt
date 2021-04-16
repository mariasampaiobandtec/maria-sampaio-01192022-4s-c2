package com.example.appcachorros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        val apiCachorros = ConexaoApiCachorros.criar()


    }

    fun cadastrarDefinitivo(view: View) {

        val apiCachorros = ConexaoApiCachorros.criar()

        var racaCachorro:EditText = findViewById(R.id.et_raca)
        var precoMedio:EditText = findViewById(R.id.et_precoMedio)
        var indicadoCriancas:Switch = findViewById(R.id.sw_indicadoCriancas)


        /*val novoCachorro = Cachorro(racaCachorro, precoMedio, indicadoCriancas)

        apiCachorros.post(novoCachorro).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 201) {

                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }

        }*/
    }
}