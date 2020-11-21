package com.example.cheersopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    override fun onResume() {
        super.onResume()
        GlobalScope.launch {
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
        }

    }

}