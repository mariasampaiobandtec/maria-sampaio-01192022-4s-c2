package com.example.appcachorros

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tela3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.atividade_tela3)

        var contador1 = 0
        var contador2 = 0

        val tvIndicador1:TextView = findViewById(R.id.et_indicador1)
        val tvIndicador2:TextView = findViewById(R.id.et_indicador2)
        val tvTotal:TextView = findViewById(R.id.et_total)
        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)

        val apiCachorro = ConexaoApiCachorros.criar()

        apiCachorro.get().enqueue(object : Callback<List<Cachorro>> {

            override fun onResponse(call: Call<List<Cachorro>>, response: Response<List<Cachorro>>) {

                response.body()?.forEach {

                    if (it.indicadoCriancas) {
                        contador1++
                    } else {
                        contador2++
                    }

                    tvIndicador1.text = "Cachorros indicados para crianças: " + contador1
                    tvIndicador2.text = "Cachorros não indicados para crianças: " + contador2
                    tvTotal.text = "Total de Cachorros:" + (contador1 + contador2)

                    val tvCachorro = TextView(baseContext)
                    tvCachorro.text = "Id: ${it.id} - Raça: ${it.raca} - Preço Médio: ${it.precoMedio} - Indicado para Crianças: ${it.indicadoCriancas}"
                    tvCachorro.setTextColor(Color.parseColor("#9911AA"))

                    layoutLista.addView(tvCachorro)
                }

            }

            override fun onFailure(call: Call<List<Cachorro>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}