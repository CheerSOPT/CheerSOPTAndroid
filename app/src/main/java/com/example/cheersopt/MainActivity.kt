package com.example.cheersopt

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.cheersopt.network.RequestToServer
import com.example.cheersopt.network.data.RatioData
import com.example.cheersopt.network.data.request.RequestBlenderData
import com.example.cheersopt.network.data.request.RequestPostRecipeData
import com.example.cheersopt.network.data.response.BlenderData
import com.example.cheersopt.network.data.response.ResponseBlenderData
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Array
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    companion object{
        var requestPostRecipeData : RequestPostRecipeData = RequestPostRecipeData("sery", 2, ArrayList<RatioData>())

    }
    var requestBlenderData : RequestBlenderData = RequestBlenderData(1,2,-1)


    var cnt = 0
    var checkedArray = arrayListOf<Boolean>(false, false, false, false, false, false, false)
    var checked = arrayListOf<Int>(-1,-1,-1)
    var recipeLevel : Int = 2
    var ratios : ArrayList<RatioData> = arrayListOf<RatioData>(RatioData(2,2),RatioData(2,3))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        requestBlenderData.drinks_idx_1= 1
//        requestBlenderData.drinks_idx_2= 2
//        requestBlenderData.drinks_idx_3= 3



        clickDrinkBtn()

        findViewById<TextView>(R.id.btn_make_drink).setOnClickListener {
            if(cnt == 2 || cnt ==3 ){
                // 서버 요청 보내
                for(i in 0..2){
                    for(cnt in 0..6){
                        if(checkedArray[cnt]){
                            checked[i] = cnt+1
                        }
                    }

                }
                if(checked[2] == -1){
                    requestBlenderData.drinks_idx_1= checked[0]
                    requestBlenderData.drinks_idx_2= checked[1]
                }else{
                    requestBlenderData.drinks_idx_1= checked[0]
                    requestBlenderData.drinks_idx_2= checked[1]
                    requestBlenderData.drinks_idx_3= checked[2]
                }
            }

            // 서버 응답 받아와
            requestBlender()

            requestPostRecipeData.recipeLevel = recipeLevel

            // 화면 전환
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
            finish()
        }




    }

    fun clickDrinkBtn() {
//
//        //활성화 하는 코드
//        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
//        // 비활성화 하는 코드
//        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)

        findViewById<ImageView>(R.id.btn_beer).setOnClickListener {
            if (cnt < 3) {
                if (checkedArray[0]) {
                    checkedArray[0] = false
                    it.alpha = 1.0F
                    cnt--
                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                } else {
                    checkedArray[0] = true
                    it.alpha = 0.4F
                    cnt++

                    if (cnt == 2 || cnt == 3)
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                    else
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                }
            } else {
                if (checkedArray[0]) {
                    checkedArray[0] = false
                    it.alpha = 1.0F
                    cnt--

                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                } else {
                    Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<ImageView>(R.id.btn_soju).setOnClickListener {
            if (cnt < 3) {
                if (checkedArray[1]) {
                    checkedArray[1] = false
                    it.alpha = 1.0F
                    cnt--
                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                } else {
                    checkedArray[1] = true
                    it.alpha = 0.4F
                    cnt++

                    if (cnt == 2 || cnt == 3)
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                    else
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                }
            } else {
                if (checkedArray[1]) {
                    checkedArray[1] = false
                    it.alpha = 1.0F
                    cnt--

                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                } else {
                    Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<ImageView>(R.id.btn_chungha).setOnClickListener {
            if (cnt < 3) {
                if (checkedArray[2]) {
                    checkedArray[2] = false
                    it.alpha = 1.0F
                    cnt--
                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                } else {
                    checkedArray[2] = true
                    it.alpha = 0.4F
                    cnt++

                    if (cnt == 2 || cnt == 3)
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                    else
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                }
            } else {
                if (checkedArray[2]) {
                    checkedArray[2] = false
                    it.alpha = 1.0F
                    cnt--

                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                } else {
                    Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<ImageView>(R.id.btn_bokbunja).setOnClickListener {
            if (cnt < 3) {
                if (checkedArray[3]) {
                    checkedArray[3] = false
                    it.alpha = 1.0F
                    cnt--
                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                } else {
                    checkedArray[3] = true
                    it.alpha = 0.4F
                    cnt++

                    if (cnt == 2 || cnt == 3)
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                    else
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                }
            } else {
                if (checkedArray[3]) {
                    checkedArray[3] = false
                    it.alpha = 1.0F
                    cnt--

                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                } else {
                    Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<ImageView>(R.id.btn_tonic).setOnClickListener {
            if (cnt < 3) {
                if (checkedArray[4]) {
                    checkedArray[4] = false
                    it.alpha = 1.0F
                    cnt--
                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                } else {
                    checkedArray[4] = true
                    it.alpha = 0.4F
                    cnt++

                    if (cnt == 2 || cnt == 3)
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                    else
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                }
            } else {
                if (checkedArray[4]) {
                    checkedArray[4] = false
                    it.alpha = 1.0F
                    cnt--

                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                } else {
                    Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<ImageView>(R.id.btn_coke).setOnClickListener {
            if (cnt < 3) {
                if (checkedArray[5]) {
                    checkedArray[5] = false
                    it.alpha = 1.0F
                    cnt--
                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                } else {
                    checkedArray[5] = true
                    it.alpha = 0.4F
                    cnt++

                    if (cnt == 2 || cnt == 3)
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                    else
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                }
            } else {
                if (checkedArray[5]) {
                    checkedArray[5] = false
                    it.alpha = 1.0F
                    cnt--

                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                } else {
                    Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        findViewById<ImageView>(R.id.btn_cider).setOnClickListener {
            if (cnt < 3) {
                if (checkedArray[6]) {
                    checkedArray[6] = false
                    it.alpha = 1.0F
                    cnt--
                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                } else {
                    checkedArray[6] = true
                    it.alpha = 0.4F
                    cnt++

                    if (cnt == 2 || cnt == 3)
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                    else
                        findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink)
                }
            } else {
                if (checkedArray[6]) {
                    checkedArray[6] = false
                    it.alpha = 1.0F
                    cnt--

                    findViewById<TextView>(R.id.btn_make_drink).setBackgroundResource(R.drawable.make_drink_active)
                } else {
                    Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun requestBlender(): Int{
        val call: Call<ResponseBlenderData> = RequestToServer.service.requestBlender( body = requestBlenderData )
        call.enqueue(object : Callback<ResponseBlenderData> {
            @SuppressLint("LongLogTag")
            override fun onFailure(call: Call<ResponseBlenderData>, t: Throwable) {
                Log.e("ResponseBlenderData 통신실패",t.toString())
            }
            @SuppressLint("LongLogTag")
            override fun onResponse(
                call: Call<ResponseBlenderData>,
                response: Response<ResponseBlenderData>
            ) {
                if (response.isSuccessful){
                    response.body().let { body ->
                        recipeLevel = body!!.data.recipeLevel_3
                        ratios = body.data.ratios
//                        Log.e("ResponseBlenderData 통신응답바디", "status: ${body.status} message : ${body.message} data : ${sentenceIdx}\"")
                    }
                }

            }

        })
        return 0
    }

}
