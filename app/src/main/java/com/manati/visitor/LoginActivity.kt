package com.manati.visitor

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.manati.visitor.model.TipoUsuario


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onStart() {
        super.onStart()
        val loginLayout = findViewById<ConstraintLayout>(R.id.loginLayout)
        //Makes authentication layout visible at startup.
        loginLayout.visibility = View.VISIBLE

        setupLoginButton()
    }

    private fun setupLoginButton() {
        val buttonLogIn = findViewById<Button>(R.id.buttonLogIn)
        buttonLogIn.setOnClickListener {
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            if (!editTextEmail.text.isNullOrBlank()) {
                val input = editTextEmail.text.toString()
                when(input){
                     TipoUsuario.PROPIETARIO.tipo-> showHome(input)
                    TipoUsuario.PROPIETARIO.tipo -> showHome(input)
                    else ->{
                        val context = this
                        val alertBuilder = AlertDialog.Builder(context)
                        alertBuilder.setTitle(title)
                        alertBuilder.setMessage("Error")
                        alertBuilder.setPositiveButton("Aceptar", null)
                        val dialog: AlertDialog = alertBuilder.create()
                        dialog.show()
                    }
                }
            }
        }
    }

    private fun showHome(tipoUsuario: String) {
        var intent = Intent(this, MainActivity::class.java).apply {
            //putExtra(tipoUsuario)
        }
        startActivity(intent)
    }

}