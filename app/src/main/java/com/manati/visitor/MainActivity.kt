package com.manati.visitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var imgMenu : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupMenu()
        navigationView.setNavigationItemSelectedListener(this)

    }

    private fun setupMenu() {
        drawerLayout = findViewById(R.id.drawarLayout)
        imgMenu = findViewById(R.id.imgMenu)

        navigationView = findViewById<NavigationView>(R.id.navDawar)
        navigationView.itemIconTintList = null
        imgMenu.setOnClickListener {
            drawarLayout.openDrawer(GravityCompat.START)
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