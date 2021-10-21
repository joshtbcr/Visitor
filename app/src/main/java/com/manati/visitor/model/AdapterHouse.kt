package com.manati.visitor.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.manati.visitor.R

class AdapterHouse(var mCtx: Context, var resources:Int, var items:List<HousesData>):ArrayAdapter<HousesData>(mCtx, resources, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources, null)

        val houseNumTextView: TextView = view.findViewById(R.id.textHouseNumRow)
        val idTextView: TextView = view.findViewById(R.id.textIdRow)

        var mItem:HousesData = items.get(position)
        houseNumTextView.text = mItem.houseNum
        idTextView.text = mItem.id
        return view
    }
}