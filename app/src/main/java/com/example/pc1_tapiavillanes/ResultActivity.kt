package com.example.pc1_tapiavillanes

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val talla: String = intent.getStringExtra("talla").toString()
        val peso: String = intent.getStringExtra("peso").toString()

        val txtIMC: TextView = findViewById(R.id.txtIMC)
        val txtClasificacion: TextView = findViewById(R.id.txtClasificacion)
        val btnGuardar: Button = findViewById(R.id.btnGuardar)

        val tallaInt: Float = talla.toFloat() / 100
        val pesoInt: Float = peso.toFloat()

        /* Calcular y mostrar IMC */
        val IMC: Float = (pesoInt / tallaInt.pow(2)) * 100
        txtIMC.text = IMC.toString()

        /* Calcular y mostrar clasificación */
        val clasificacion: String

        if (IMC < 18.5) {
            clasificacion = "Bajo peso"
            txtClasificacion.setTextColor(Color.YELLOW)
        } else if (IMC >= 18.5 && IMC <= 24.9) {
            clasificacion = "Normal"
            txtClasificacion.setTextColor(Color.GREEN)
        } else if (IMC >= 25 && IMC <= 29.9) {
            clasificacion = "Sobrepeso"
            txtClasificacion.setTextColor(Color.MAGENTA)
        } else if (IMC >= 30 && IMC <= 34.9) {
            clasificacion = "Obesidad grado I"
            txtClasificacion.setTextColor(Color.MAGENTA)
        } else if (IMC >= 35 && IMC <= 39.9) {
            clasificacion = "Obesidad grado II"
            txtClasificacion.setTextColor(Color.RED)
        } else {
            clasificacion = "Obesidad grado III"
            txtClasificacion.setTextColor(Color.RED)
        }

        txtClasificacion.text = clasificacion

        /* Toast al hacer clic en el botón */
        btnGuardar.setOnClickListener() {
            Toast.makeText(this,"IMC: ${IMC}, Clasificación: ${clasificacion}", Toast.LENGTH_LONG).show()
        }
    }
}