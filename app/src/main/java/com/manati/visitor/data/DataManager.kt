package com.manati.visitor.data

import com.manati.visitor.model.HousesData

object DataManager {
    val houses = ArrayList<HousesData>()

    init {
        initializeHouses()
    }

    private fun initializeHouses() {
        var house = HousesData("604110141", "25A")
        houses.add(house)

        house = HousesData("604110141", "30A")
        houses.add(house)

        house = HousesData("604110141", "27BA")
        houses.add(house)
    }
}