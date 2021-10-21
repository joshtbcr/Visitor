package com.manati.visitor

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.manati.visitor.data.DataManager
import com.manati.visitor.model.Car
import com.manati.visitor.model.Constants
import com.manati.visitor.model.ModelCar
import com.manati.visitor.model.TipoUsuario

class CarsActivity : AppCompatActivity() {
    private var carPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)

        setUp()
    }

    private fun setUp() {
        val buttonCarSave = findViewById<Button>(R.id.button_carSave)
        buttonCarSave.setOnClickListener {
            val placaText = findViewById<EditText>(R.id.placaInput)
            val modeloText = findViewById<EditText>(R.id.modeloInput)
            val marcaText = findViewById<EditText>(R.id.marcaInput)
            if (!placaText.text.isNullOrBlank() && !modeloText.text.isNullOrBlank() && !marcaText.text.isNullOrBlank()) {
                val placatxt = placaText.text.toString()
                val modelotxt = modeloText.text.toString()
                val marcatxt = marcaText.text.toString()

                DataManager.cars.add(ModelCar())
                carPosition = DataManager.cars.lastIndex
                saveCar()

                showHome()

            } else {
                val context = this
                val alertBuilder = AlertDialog.Builder(context)
                alertBuilder.setTitle(title)
                alertBuilder.setMessage("Se deben rellenar todos los campos.")
                alertBuilder.setPositiveButton("Aceptar", null)
                val dialog: AlertDialog = alertBuilder.create()
                dialog.show()
            }

            }
        }

    private fun showHome() {
        finish()
    }

    private fun saveCar() {
        val placaText = findViewById<EditText>(R.id.placaInput)
        val modeloText = findViewById<EditText>(R.id.modeloInput)
        val marcaText = findViewById<EditText>(R.id.marcaInput)

        val car = DataManager.cars[carPosition]
        car.placa = placaText.text.toString()
        car.modelo = modeloText.text.toString()
        car.marca = marcaText.text.toString()

    }



}