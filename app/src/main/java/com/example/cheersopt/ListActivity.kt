package com.example.cheersopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cheersopt.network.RequestToServer
import com.example.cheersopt.network.data.response.ResponseRecipeData
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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


        val call : Call<ResponseRecipeData> = RequestToServer.service.requestRecipe()
        call.enqueue(object : Callback<ResponseRecipeData> {
            override fun onFailure(call: Call<ResponseRecipeData>, t: Throwable) {
                Log.e("통신실패",t.toString())
            }

            override fun onResponse(
                call: Call<ResponseRecipeData>,
                response: Response<ResponseRecipeData>
            ) {
                response.takeIf { it.isSuccessful}
                    ?.body()
                    ?.let { it ->
                        //it.data.userName
                        recyclerAdapter.data = it.data.toMutableList()
                        recyclerAdapter.notifyDataSetChanged()
                    } ?: showError(response.errorBody())
            }
        })
        recyclerView.addItemDecoration(ItemDecoration())
        recyclerAdapter.notifyDataSetChanged()
    }

    private fun showError(error : ResponseBody?){
        val e = error ?: return
        val ob = JSONObject(e.string())
        Toast.makeText(this, ob.getString("message"), Toast.LENGTH_SHORT).show()
    }
}