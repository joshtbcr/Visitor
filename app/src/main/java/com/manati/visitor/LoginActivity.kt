package com.manati.visitor

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.manati.visitor.data.Usuarios
import com.manati.visitor.model.Constants
import com.manati.visitor.model.Usuario


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
            val editTextCedula = findViewById<EditText>(R.id.editTextEmail)
            if (!editTextCedula.text.isNullOrBlank()) {
                val inputCedula = editTextCedula.text.toString()

                val usuarios = Usuarios()
                usuarios.cargarUsuarios()
                val usuario = usuarios.existeUsuario(inputCedula)

                if(usuario !=null){
                    showHome(usuario)
                }else{
                    val context = this
                    val alertBuilder = AlertDialog.Builder(context)
                    alertBuilder.setTitle(title)
                    alertBuilder.setMessage("Usuario no existe.")
                    alertBuilder.setPositiveButton("Ok", null)
                    val dialog: AlertDialog = alertBuilder.create()
                    dialog.show()

                }
            }
        }
    }

    private fun showHome(usuario: Usuario) {
        var intent = Intent(this, MainActivity::class.java).apply {
            putExtra(Constants.CEDULA,usuario.cedula)
            putExtra(Constants.NOMBRE,usuario.nombreCompleto)
            putExtra(Constants.TIPOUSUARIO,usuario.tipoUsuario)
        }
        startActivity(intent)
    }

}