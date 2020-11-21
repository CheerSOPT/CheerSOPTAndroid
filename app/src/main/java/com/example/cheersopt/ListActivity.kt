package com.example.cheersopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ListActivity : AppCompatActivity() {
    private lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val main_btn = findViewById<TextView>(R.id.main_btn)
        main_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

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