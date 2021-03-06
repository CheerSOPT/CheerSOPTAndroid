package com.example.cheersopt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cheersopt.network.data.response.ResponseRecipeData

class RecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerViewHolder>() {
    var data = mutableListOf<ResponseRecipeData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.grid_item_list, parent, false)

        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.onBind(data[position])
    }

}