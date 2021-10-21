package com.manati.visitor

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.manati.visitor.data.DataManager
import com.manati.visitor.model.AdapterHouse
import com.manati.visitor.model.HousesData
import com.manati.visitor.model.ModelCar


class ListHousesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_houses)

        var listView = findViewById<ListView>(R.id.listHouses)

        listView.adapter = AdapterHouse(this, R.layout.row_house, DataManager.houses)
    }

}