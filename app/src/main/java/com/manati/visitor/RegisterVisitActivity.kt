package com.manati.visitor

import android.app.Activity
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputLayout




class RegisterVisitActivity : AppCompatActivity() {

    private val MESSAGE_ERROR: String = "Error"
    private val MESSAGE_ALERT: String = "Alerta"

    lateinit var idVisitante: EditText
    lateinit var nombreVisitante: EditText
    lateinit var apellidoVisitante: EditText
    lateinit var fechaVisita: EditText
    lateinit var horaVisita: EditText
    lateinit var celularVisita: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_visit)

        viewInitializations()
        saveVisit()
    }

    fun viewInitializations() {
        idVisitante = findViewById(R.id.idVisitanteInput)
        nombreVisitante = findViewById(R.id.nombreVisitanteInput)
        apellidoVisitante = findViewById(R.id.apellidoVisitanteInput)
        fechaVisita = findViewById(R.id.fechaIngresoInput)
        horaVisita = findViewById(R.id.horaIngresoInput)
        celularVisita = findViewById(R.id.celularInput)

    }


    private fun saveVisit() {

        this.title = "Registrar visita"
        val regVisitButton = findViewById<Button>(R.id.reg_visit_button)


        regVisitButton.setOnClickListener {

            val idVisita = idVisitante.text.toString()
            val nombreVisita = nombreVisitante.text.toString()
            val apellidoVisita = apellidoVisitante.text.toString()
            val fechaVisita = fechaVisita.text.toString()
            val horaVisita = horaVisita.text.toString()
            val celular = celularVisita.text.toString()

            if (validateForm()) {

                val levelUpMessage = "¡Subiste de nivel!"
                val newAbility = "Habilidad Tajo aprendida"

                print(levelUpMessage)
                print(newAbility)
                }
                alert("Registro exitoso", MESSAGE_ALERT)
                clearForm()

            }/* else {

            }*/
        }


    private fun validateForm(): Boolean {
        var idvisitante = findViewById<TextInputLayout>(R.id.idVisitanteInput)
        var nombreVisitante = findViewById<TextInputLayout>(R.id.nombreVisitanteInput)
        var apellidoVisitante = findViewById<TextInputLayout>(R.id.apellidoVisitanteInput)
        var fechaVisita = findViewById<TextInputLayout>(R.id.fechaIngresoInput)
        var horaVisita = findViewById<TextInputLayout>(R.id.horaIngresoInput)
        var celularVisita = findViewById<TextInputLayout>(R.id.celularInput)

        var isValidForm = true

        if (isValidForm && idvisitante.isEmpty()) {

            alert("Debe ingresar el id del visitante", MESSAGE_ERROR)
            isValidForm = false
        }
        if (isValidForm && nombreVisitante.isEmpty()) {
            alert("Debe ingresar el nombre del visitante", MESSAGE_ERROR)
            isValidForm = false
        }
        if (isValidForm && apellidoVisitante.isEmpty()) {
            alert("Debe ingresar el apellido del visitante", MESSAGE_ERROR)
            isValidForm = false
        }
        if (isValidForm && fechaVisita.isEmpty()) {
            alert("Debe ingresar la fecha de visita del visitante", MESSAGE_ERROR)
            isValidForm = false
        }
        if (isValidForm && horaVisita.isEmpty()) {
            alert("Debe ingresar la hora de visita del visitante", MESSAGE_ERROR)
            isValidForm = false
        }
        if (isValidForm && celularVisita.isEmpty()) {
            alert("Debe ingresar numero de celular de la visita", MESSAGE_ERROR)
            isValidForm = false
        }
        return isValidForm
    }

    private fun alert(messageAlert: String, alertType: String) {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle(alertType)
        alertBuilder.setMessage(messageAlert)
        alertBuilder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = alertBuilder.create()
        dialog.show()
    }

    private fun clearForm() {

    }



}