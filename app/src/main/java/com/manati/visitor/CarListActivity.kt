package com.manati.visitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.manati.visitor.data.DataManager
import com.manati.visitor.model.AdapterCar
import com.manati.visitor.model.ModelCar

class CarListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)

        var listView = findViewById<ListView>(R.id.listCars)

        listView.adapter = AdapterCar(this, R.layout.row_car, DataManager.cars)

    }
}