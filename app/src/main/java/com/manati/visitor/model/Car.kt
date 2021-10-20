package com.manati.visitor.model

class Car {
    var placa = ""
    var modelo = ""
    var marca = ""

    constructor()

    constructor(
        placa: String,
        modelo: String,
        marca: String
    ){
        this.placa = placa
        this.modelo = modelo
        this.marca = marca
    }
}