package com.manati.visitor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.manati.visitor.model.Constants
import com.manati.visitor.model.TipoUsuario
import com.manati.visitor.model.Usuario
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var imgMenu : ImageView
    private lateinit var usuario : Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras
        val cedula = bundle?.getString(Constants.CEDULA)
        val nombre = bundle?.getString(Constants.NOMBRE)
        val tipoUsuario = bundle?.getString(Constants.TIPOUSUARIO)

        usuario = Usuario(cedula!!,nombre!!,tipoUsuario!!)


        when (usuario.tipoUsuario) {
            TipoUsuario.PROPIETARIO.tipo -> {
                setContentView(R.layout.activity_main)
            }
            TipoUsuario.SEGURIDAD.tipo -> {
                setContentView(R.layout.activity_main_security)
            }

        }

        setupMenu()
        navigationView.setNavigationItemSelectedListener(this)


    }

    private fun setupMenu() {
        drawerLayout = findViewById(R.id.drawarLayout)
        imgMenu = findViewById(R.id.imgMenu)

        navigationView = findViewById<NavigationView>(R.id.navDawar)
        navigationView.itemIconTintList = null
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        var headerView  = navigationView.getHeaderView(0)
        var nombreMenu = headerView.findViewById<TextView>(R.id.nombreMenuText)
        nombreMenu.setText(usuario.nombreCompleto)

        val tipoUsuarioMenu = headerView.findViewById<TextView>(R.id.tipoUsuarioMenuText)
        tipoUsuarioMenu.setText(usuario.tipoUsuario)

    }
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        var intentMenu = Intent()
        intentMenu.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        when (menuItem.itemId) {

            //---------------------------Buyer Items----------------------------------

            R.id.home -> {
                startActivity(Intent(this, MainActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.registrarCasa -> {
                startActivity(Intent(this, RegisterHouseActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START)

            }
            R.id.listaCasas -> {
                startActivity(Intent(this, ListHousesActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.registrarVisita -> {
                startActivity(Intent(this, RegisterVisitActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START)

            }
            R.id.listaVisitas -> {
                startActivity(Intent(this, ListVisitActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START)

            }
            R.id.registrarCarro -> {
                startActivity(Intent(this, CarsActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START)

            }
            R.id.listaCarros -> {
                startActivity(Intent(this, CarListActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            else -> super.onOptionsItemSelected(menuItem)
        }

        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            finishAffinity()
        }
    }

}