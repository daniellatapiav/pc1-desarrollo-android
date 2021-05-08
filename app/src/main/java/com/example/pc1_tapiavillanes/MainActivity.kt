package com.example.pc1_tapiavillanes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtTalla: TextView = findViewById(R.id.txtTalla)
        var txtPeso: TextView = findViewById(R.id.txtPeso)
        var btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener() {
            verResultado(txtTalla.text.toString(), txtPeso.text.toString())
        }
    }

    private fun verResultado(talla: String, peso: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("talla", talla)
        intent.putExtra("peso", peso)
        startActivity(intent)
    }
}