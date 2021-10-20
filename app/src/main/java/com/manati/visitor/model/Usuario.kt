package com.manati.visitor.model

class Usuario (var cedula: String,var nombreCompleto: String,var tipoUsuario: String){
    override fun toString(): String {
        return "Usuario(cedula='$cedula', nombreCompleto='$nombreCompleto', tipoUsuario='$tipoUsuario')"
    }
}

enum class TipoUsuario(val tipo:String){
    SEGURIDAD("seguridad"),
    PROPIETARIO("propietario")
}