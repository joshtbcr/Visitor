package com.manati.visitor.model

class Visit {
    var idVisitante = ""
    var nombreVisitante = ""
    var apellidoVisitante = ""
    var fechaVisita = ""
    var horaVisita = ""
    var celularVisitante = "";

    constructor()

    constructor(
        idVisitante: String,
        nombreVisitante: String,
        apellidoVisitante: String,
        fechaVisita: String,
        horaVisita: String,
        celularVisitante: String
    ){
        this.idVisitante = idVisitante
        this.nombreVisitante = nombreVisitante
        this.apellidoVisitante = apellidoVisitante
        this.fechaVisita = fechaVisita
        this.horaVisita = horaVisita
        this.celularVisitante = celularVisitante
    }
}