package com.manati.visitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.manati.visitor.model.AdapterCar
import com.manati.visitor.model.Car
import com.manati.visitor.model.ModelCar
import com.manati.visitor.model.Usuario

class CarListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)


        var listView = findViewById<ListView>(R.id.listCars)

        var list = mutableListOf<ModelCar>()

        list.add(ModelCar("MNY333","2016","Toyota",R.drawable.ic_car))
        list.add(ModelCar("SXS767","2019","Suzuki",R.drawable.ic_car))
        list.add(ModelCar("PSL756","2015","BMW",R.drawable.ic_car))

        listView.adapter = AdapterCar(this, R.layout.row_car, list)

    }
}