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
import com.manati.visitor.model.TipoUsuario

class RegisterHouseActivity : AppCompatActivity() {
    private var housePosition = 0

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

                DataManager.houses.add(HousesData())
                housePosition = DataManager.houses.lastIndex

                saveHouse()
                val int = DataManager.houses.size
//                val newHouse = HousesData(
//                    idText,
//                    houseNumText)

//                DataManager.houses.add(newHouse)

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

   /* override fun onPause() {
        super.onPause()
        saveHouse()
    }*/

    private fun saveHouse() {
        val idText = findViewById<EditText>(R.id.idInput)
        val houseNumText = findViewById<EditText>(R.id.houseNumInput)

        val house = DataManager.houses[housePosition]
        house.id = idText.text.toString()
        house.houseNum = houseNumText.text.toString()
    }
}
