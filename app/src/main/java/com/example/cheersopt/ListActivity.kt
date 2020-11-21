package com.example.cheersopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ListActivity : AppCompatActivity() {
    private lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerAdapter = RecyclerAdapter(this)

        val recyclerView = findViewById<RecyclerView>(R.id.main_rcv)

        recyclerView.adapter = recyclerAdapter
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager

        recyclerAdapter.data = mutableListOf(
            DrinkData("다빈주", "소주3\n맥주1"),
            DrinkData("다빈주", "소주3\n맥주1\n사이다1"),
            DrinkData("다빈주", "소주3\n맥주1"),
            DrinkData("다빈주", "소주3\n맥주3")
        )
        recyclerAdapter.notifyDataSetChanged()
    }
}