package com.example.cheersopt

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.drink_name);
    private val subTitle: TextView = itemView.findViewById(R.id.drink_species);

    fun onBind(data : DrinkData) {
        title.text = data.drink_name
        subTitle.text = data.drink_species
    }

}