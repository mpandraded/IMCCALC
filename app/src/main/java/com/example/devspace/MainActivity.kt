package com.example.devspace

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnCalc: Button = findViewById(R.id.btnCalc)
        val edtAltura : EditText = findViewById(R.id.edtHight)
        val edtPeso: EditText = findViewById(R.id.edtPeso)
       // val edtResultado: TextView = findViewById(R.id.edtText)

        btnCalc.setOnClickListener {
            var alturaStr: String = edtAltura.text.toString()
            var pesoStr: String = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
                var altura: Float = alturaStr.toFloat()
                var peso: Float = pesoStr.toFloat()
                var alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal
                //edtResultado.text = result.toString()
                //println("MEU IMC " + result)
                val intent = Intent( this, ResultActivity::class.java)
                    .apply {
                        putExtra("Result_Extra", result)
                    }
                startActivity(intent)
        } else {
                Toast.makeText(this, "Por Favor informar todos os campos", Toast.LENGTH_LONG).show()

            }        }

    }
}