package com.manati.visitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.manati.visitor.model.AdapterCar
import com.manati.visitor.model.ModelCar

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