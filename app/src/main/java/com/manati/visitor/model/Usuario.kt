package com.manati.visitor.model

class Usuario {
    var cedula = ""
    var nombreCompleto = ""
    var tipoUsuario= ""
}

enum class TipoUsuario(val tipo:String){
    SEGURIDAD("seguridad"),
    PROPIETARIO("propietario")
}