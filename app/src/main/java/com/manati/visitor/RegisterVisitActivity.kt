package com.manati.visitor

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.manati.visitor.model.Constants
import com.manati.visitor.model.Visit

class RegisterVisitActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_visit)

        setUp()
    }

    private fun setUp() {
        val buttonCarSave = findViewById<Button>(R.id.button_reg_visit)
        buttonCarSave.setOnClickListener {
            val idText = findViewById<EditText>(R.id.id_visitante)
            val nombreText = findViewById<EditText>(R.id.nombre_visitante)
            val apellidoText = findViewById<EditText>(R.id.apellido_visitante)
            val fechaVisita = findViewById<EditText>(R.id.fecha_ingreso)
            val horaVisita = findViewById<EditText>(R.id.hora_ingreso)
            val celularVisita = findViewById<EditText>(R.id.celular_visitante)

            if (!idText.text.isNullOrBlank() && !nombreText.text.isNullOrBlank() && !apellidoText.text.isNullOrBlank() &&
            !fechaVisita.text.isNullOrBlank() && !horaVisita.text.isNullOrBlank() && !celularVisita.text.isNullOrBlank()) {
                val idtxt = idText.text.toString()
                val nombretxt = nombreText.text.toString()
                val apellidotxt = apellidoText.text.toString()
                val fechatxt = fechaVisita.text.toString()
                val horatxt = horaVisita.text.toString()
                val celulartxt = celularVisita.text.toString()
                Visit(
                    idtxt,
                    nombretxt,
                    apellidotxt,
                    fechatxt,
                    horatxt,
                    celulartxt
                )
                Log.d("myTag", "This is my message $idText");

                val miVisita = ArrayList<String>()
                miVisita.add(idtxt)
                miVisita.add(nombretxt)
                miVisita.add(apellidotxt)
                miVisita.add(fechatxt)
                miVisita.add(horatxt)
                miVisita.add(celulartxt)

                //milista = arrayOf(idText, nombreText, apellidoText, fechaVisita, horaVisita, celularVisita)

                print(nombreText)
                showListVisit("propietario", miVisita)


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

    private fun showListVisit(tipoUsuario: String, visita: ArrayList<String>) {
        val listVisitIntent = Intent(this, ListVisitActivity::class.java).apply {
            putExtra(Constants.TIPOUSUARIO, tipoUsuario)
            putStringArrayListExtra("visita", visita)
        }
        startActivity(listVisitIntent)
        finish()
    }
}
