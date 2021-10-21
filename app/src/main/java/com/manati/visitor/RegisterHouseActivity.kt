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
import com.manati.visitor.model.HousesData

class RegisterHouseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_house)

        setUp()
    }

    private fun setUp() {
        val buttonHouseSave = findViewById<Button>(R.id.btnSaveHouse)
        buttonHouseSave.setOnClickListener {
            val idText = findViewById<EditText>(R.id.idInput)
            val houseNumText = findViewById<EditText>(R.id.houseNumInput)
            if (!houseNumText.text.isNullOrBlank() && !idText.text.isNullOrBlank()) {
                val houseNumText = houseNumText.text.toString()
                val idText = idText.text.toString()


                val newHouse = HousesData(
                    idText,
                    houseNumText)

                DataManager.houses.add(newHouse)

//                notePosition = DataManager.houses.lastIndex

                showHome("propietario")

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

    private fun showHome(tipoUsuario: String) {
        val homeIntent = Intent(this, MainActivity::class.java).apply {
            putExtra(Constants.TIPOUSUARIO, tipoUsuario)
        }
        startActivity(homeIntent)
        finish()
    }
}