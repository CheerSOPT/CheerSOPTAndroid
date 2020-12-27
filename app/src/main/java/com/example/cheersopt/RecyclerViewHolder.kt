package com.example.cheersopt

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cheersopt.MainActivity.Companion.STACK_COLOR
import com.example.cheersopt.network.data.response.ResponseRecipeData

class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.drink_name)
    private val subTitle: TextView = itemView.findViewById(R.id.drink_species)
    private val stack1: TextView = itemView.findViewById(R.id.b_stack1)
    private val stack2: TextView = itemView.findViewById(R.id.b_stack2)
    private val stack3: TextView = itemView.findViewById(R.id.b_stack3)
    private val stack4: TextView = itemView.findViewById(R.id.b_stack4)
    private val stack5: TextView = itemView.findViewById(R.id.b_stack5)
    fun onBind(data : ResponseRecipeData.Data) {
        title.text = data.recipe_name
        var list = ArrayList<Int>()
        var S = ""
        for(i in 0 until data.RATIO_TBs.size) {
            if(i == data.RATIO_TBs.size - 1) {
                S += data.RATIO_TBs[i].DRINKS_TB.drinks_name + data.RATIO_TBs[i].ratio_percent
            }
            else {
                S = S + data.RATIO_TBs[i].DRINKS_TB.drinks_name + data.RATIO_TBs[i].ratio_percent + "\n"
            }

            for(j in 0 until data.RATIO_TBs[i].ratio_percent) {
                list.add(data.RATIO_TBs[i].drinks_idx)
            }
        }
        subTitle.text = S

        if(!list.isEmpty()) {
            stack1.setBackgroundResource(STACK_COLOR[list.get(0)])
            stack2.setBackgroundResource(STACK_COLOR[list.get(1)])
            stack3.setBackgroundResource(STACK_COLOR[list.get(2)])
            stack4.setBackgroundResource(STACK_COLOR[list.get(3)])
            stack5.setBackgroundResource(STACK_COLOR[list.get(4)])
        }
    }

}