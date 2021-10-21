package com.manati.visitor.data

import com.manati.visitor.model.HousesData

object DataManager {
    val houses = ArrayList<HousesData>()

    init {
        initializeHouses()
    }

    private fun initializeHouses() {
        var house = HousesData("115990150", "25A")
        houses.add(house)

        house = HousesData("115990150", "30A")
        houses.add(house)

        house = HousesData("115990150", "27BA")
        houses.add(house)

        house = HousesData("115990150", "30A")
        houses.add(house)

    }
}