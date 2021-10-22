package com.manati.visitor.data

import com.manati.visitor.R
import com.manati.visitor.model.HousesData
import com.manati.visitor.model.ModelCar

object DataManager {
    val houses = ArrayList<HousesData>()
    var cars = ArrayList<ModelCar>()

    init {
        initializeHouses()
        initializeCars()
    }

    private fun initializeHouses() {
        var house = HousesData("604110141", "25A")
        houses.add(house)

        house = HousesData("604110141", "30A")
        houses.add(house)

        house = HousesData("604110141", "27BA")
        houses.add(house)
    }
    private fun initializeCars() {

        var car = ModelCar("MNY333","2016","Toyota")
        cars.add(car)

       //car = ModelCar("SXS767","2019","Suzuki")
       //cars.add(car)

       //car = ModelCar("PSL756","2015","BMW")
       //cars.add(car)
    }


}