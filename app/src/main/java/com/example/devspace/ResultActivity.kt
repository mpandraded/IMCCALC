package com.example.devspace

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvResult = findViewById<TextView>(R.id.result)
        val tvClassificacao = findViewById<TextView>(R.id.classificacao)
        val result = intent.getFloatExtra("Result_Extra", 0.1f)
        tvResult.text = result.toString()



        val classificacao = if (result <= 18.5f) {
            "ABAIXO DO PESO"
        } else if (result <= 24.9f) {
            "NORMAL"
        } else if (result <= 29.9f) {
            "SOBREPESO"
        } else if (result <= 39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE MÓRBIDA"
        }
        tvClassificacao.text = getString(R.string.message_classificação, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}
