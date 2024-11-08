package com.example.convertisseurdevise

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputDinars: EditText
    private lateinit var outputEuros: TextView
    private lateinit var convertButton: Button
    private val TAUX_CONVERSION = 0.003 // Taux de conversion Dinars -> Euros

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des vues
        inputDinars = findViewById(R.id.inputDinars)
        outputEuros = findViewById(R.id.outputEuros)
        convertButton = findViewById(R.id.convertButton)

        // Définition du listener pour le bouton
        convertButton.setOnClickListener {
            convertir()
        }
    }

    private fun convertir() {
        val montantDinars = inputDinars.text.toString()

        if (montantDinars.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer un montant", Toast.LENGTH_SHORT).show()
            return
        }

        val dinars = montantDinars.toDouble()
        val euros = dinars * TAUX_CONVERSION

        outputEuros.text = String.format("%.2f", euros)
    }
}
