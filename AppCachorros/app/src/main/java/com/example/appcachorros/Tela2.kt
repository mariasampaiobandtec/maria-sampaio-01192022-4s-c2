package com.example.appcachorros

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.atividade_tela2)

    }

    fun cadastrarDefinitivo(view: View) {

        val apiCachorros = ConexaoApiCachorros.criar()

        val imFoto:ImageView = findViewById(R.id.iv_foto)
        val tvFrase:TextView = findViewById(R.id.tv_frase)
        var racaCachorro:EditText = findViewById(R.id.et_raca)
        var precoMedio:EditText = findViewById(R.id.et_precoMedio)
        var indicadoCriancas:Switch = findViewById(R.id.sw_indicadoCriancas)

        val novoCachorro = Cachorro(null, racaCachorro.text.toString(), precoMedio.text.toString().toInt(), indicadoCriancas.isChecked)

        apiCachorros.post(novoCachorro).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 201) {
                    imFoto.setImageResource(R.drawable.feliz)
                    tvFrase.text = "Cão cadastrado com sucesso"
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }
}