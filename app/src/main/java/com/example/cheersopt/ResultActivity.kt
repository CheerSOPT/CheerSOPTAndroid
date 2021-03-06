package com.example.cheersopt

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import com.example.cheersopt.MainActivity.Companion.BEVERAGE_IDX
import com.example.cheersopt.MainActivity.Companion.STACK_COLOR
import com.example.cheersopt.MainActivity.Companion.blendedCnt
import com.example.cheersopt.MainActivity.Companion.recipe
import com.example.cheersopt.MainActivity.Companion.requestPostRecipeData
import com.example.cheersopt.network.RequestToServer
import com.example.cheersopt.network.data.response.ResponsePostRecipeData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result) }

    override fun onResume() {
        super.onResume()
        GlobalScope.launch {
            runOnUiThread {
                findViewById<TextView>(R.id.result_beverage_tv_beverage3).text = BEVERAGE_IDX[requestPostRecipeData.ratios[0].drinksIdx] + " ${requestPostRecipeData.ratios[0].ratioPercent}잔"
                findViewById<TextView>(R.id.result_beverage_tv_beverage2).text = BEVERAGE_IDX[requestPostRecipeData.ratios[1].drinksIdx] + " ${requestPostRecipeData.ratios[1].ratioPercent}잔"
                findViewById<TextView>(R.id.result_beverage_tv_beverage1).text = BEVERAGE_IDX[requestPostRecipeData.ratios[2].drinksIdx] + " ${requestPostRecipeData.ratios[2].ratioPercent}잔"
            }
            delay(1000L)
            runOnUiThread {
                findViewById<TextView>(R.id.result_beverage_tv1).text = "환상 주 이름을 정해주세요"
                findViewById<EditText>(R.id.result_beverage_et).visibility = View.VISIBLE
                findViewById<TextView>(R.id.result_beverage_btn).visibility = View.VISIBLE
            }

            findViewById<EditText>(R.id.result_beverage_et)
                .startAnimation(AnimationUtils.loadAnimation(this@ResultActivity, R.anim.fade_in_up))
            findViewById<TextView>(R.id.result_beverage_btn)
                .startAnimation(AnimationUtils.loadAnimation(this@ResultActivity, R.anim.fade_in_up))

            delay(500L)
            runOnUiThread {
                findViewById<TextView>(R.id.result_beverage_tv_cnt).visibility = View.VISIBLE
                findViewById<TextView>(R.id.result_beverage_tv_cnt2).visibility = View.VISIBLE
            }

            showStack(findViewById<TextView>(R.id.result_beverage_stack1), Integer.parseInt(recipe[0]))
            delay(100L)
            showStack(findViewById<TextView>(R.id.result_beverage_stack2), Integer.parseInt(recipe[1]))
            delay(100L)
            showStack(findViewById<TextView>(R.id.result_beverage_stack3), Integer.parseInt(recipe[2]))
            delay(100L)
            showStack(findViewById<TextView>(R.id.result_beverage_stack4), Integer.parseInt(recipe[3]))
            delay(100L)
            showStack(findViewById<TextView>(R.id.result_beverage_stack5), Integer.parseInt(recipe[4]))
        }

        findViewById<EditText>(R.id.result_beverage_et).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                requestPostRecipeData.recipeName = findViewById<EditText>(R.id.result_beverage_et).text.toString()

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 글자수 세기
                findViewById<TextView>(R.id.result_beverage_tv_cnt).text=
                    findViewById<EditText>(R.id.result_beverage_et).text.toString().length.toString()

            }

        })

        findViewById<TextView>(R.id.result_beverage_btn).setOnClickListener {
            // 서버 요청
            postRecipe()
            // 화면 전환
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }

    }



    private fun postRecipe(): Int{
        val call: Call<ResponsePostRecipeData> = RequestToServer.service.postRecipe(body = requestPostRecipeData)
        call.enqueue(object : Callback<ResponsePostRecipeData> {
            @SuppressLint("LongLogTag")
            override fun onFailure(call: Call<ResponsePostRecipeData>, t: Throwable) {
                Log.e("ResponsePostRecipeData 통신실패",t.toString())
            }
            @SuppressLint("LongLogTag")
            override fun onResponse(
                call: Call<ResponsePostRecipeData>,
                response: Response<ResponsePostRecipeData>
            ) {
                if (response.isSuccessful){
                    response.body().let { body ->
                        Log.e("ResponsePostRecipeData 통신요청바디", "recipeLevel: ${requestPostRecipeData.ratios} recipeName : ${requestPostRecipeData.recipeName} \"")

                        Log.e("ResponsePostRecipeData 통신응답바디", "status: ${body!!.status} message : ${body!!.message} \"")
                    }
                }

            }

        })
        return 0
    }

    private fun showStack(view: View, drinksIdx : Int){
        view.setBackgroundResource(STACK_COLOR[drinksIdx])

        runOnUiThread {
            view.visibility = View.VISIBLE
        }
        view.startAnimation(AnimationUtils.loadAnimation(this@ResultActivity, R.anim.fade_in_up))
    }






}