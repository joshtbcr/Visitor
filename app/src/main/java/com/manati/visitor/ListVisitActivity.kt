package com.manati.visitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.manati.visitor.model.*

class ListVisitActivity : AppCompatActivity() {

   // val miVisita: MutableList<Visit> = ArrayList()
    val miVisita = ArrayList<Visit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_visit)

        var listView = findViewById<ListView>(R.id.listVisit)

        var list = mutableListOf<ModelVisit>()

        list.add(ModelVisit("604140362","Elian","12/12/2021",R.drawable.ic_visit))
        list.add(ModelVisit("603710339","Irian","21/11/2021",R.drawable.ic_visit))
        list.add(ModelVisit("602357841","Monica","14/11/2021",R.drawable.ic_visit))

        listView.adapter = AdapterVisit(this, R.layout.row_visit, list)
    }

    private fun listaGuardar(){

        val lista: ArrayList<String>? = intent.getStringArrayListExtra("visita")

        val visit = Visit()
        visit.idVisitante = lista?.get(0).toString()
        visit.nombreVisitante = lista?.get(1).toString()
        visit.apellidoVisitante = lista?.get(2).toString()
        visit.fechaVisita = lista?.get(3).toString()
        visit.horaVisita = lista?.get(4).toString()

        miVisita.add(visit)
        listar()

    }

    private fun listar(){

        for(i in 1..miVisita.size){

            if (i == 1){
                val idVisitL = findViewById<TextView>(R.id.idVisit1)
                idVisitL.setText(miVisita[0].idVisitante);

                val nombreVisitL = findViewById<TextView>(R.id.nameVisit1)
                nombreVisitL.setText(miVisita[0].nombreVisitante)


                val fechaVisitL = findViewById<TextView>(R.id.idVisit1)
                fechaVisitL.setText(miVisita[0].fechaVisita + " hora: " + miVisita[0].horaVisita)
            }



        }


    }


}