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
            DrinkData("현주야 한 번\n 더 가자", "토닉5"),
            DrinkData("치얼솝트 1위\n 축하주", "소주2\n토닉3"),
            DrinkData("혜인아 운\n좋다^^", "청하3\n토닉2"),
            DrinkData("아...약해 \n약해....", "맥주3\n콜라2"),
            DrinkData("오늘 구디 희영이\n가 점령", "소주1\n사이다4"),
            DrinkData("치얼솝트 리액션왕\n 예나", "복분자4\n소주1"),
            DrinkData("지리는 이기상\n 첫 회식", "복분자2\n청하2\n사이다1")
        )
        recyclerAdapter.notifyDataSetChanged()
    }
}