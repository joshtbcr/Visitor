package com.manati.visitor.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.manati.visitor.R

class AdapterVisit(var mCtx: Context, var resources:Int, var items:List<ModelVisit>):
    ArrayAdapter<ModelVisit>(mCtx, resources, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)

        val imageView: ImageView = view.findViewById(R.id.imageVisit)
        val idTextView: TextView = view.findViewById(R.id.idVisit1)
        val nombreTextView: TextView = view.findViewById(R.id.nameVisit1)
        val fechatex: TextView = view.findViewById(R.id.dateVisit1)

        var mItem:ModelVisit = items.get(position)
        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
        idTextView.text = mItem.id
        nombreTextView.text = mItem.nombre
        fechatex.text = mItem.fechaIngreso


        return view
    }
}

