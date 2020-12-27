package com.example.cheersopt


import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemDecoration: RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val childeCnt = parent.childCount


        for(i in 0 until childeCnt){
            val view = parent.getChildAt(i)
            val pos = parent.getChildAdapterPosition(view)

        }

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos  = parent.getChildAdapterPosition(view)
        val itemCnt = state.itemCount
        //val itemCnt = parent.childCount

        if(pos == 0 && pos == 1){
            outRect.top = 20
            outRect.bottom = 20
        }else{
            outRect.bottom = 20

        }

        if(pos%2 == 0){
            outRect.right = 10
        }else{
            outRect.left = 10
        }



    }

}