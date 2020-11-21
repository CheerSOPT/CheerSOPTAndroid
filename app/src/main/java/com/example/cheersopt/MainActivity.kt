package com.example.cheersopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickDrinkBtn()
    }

    fun clickDrinkBtn() {
        var cnt = 0
        var checkedArray = arrayListOf<Boolean>(false, false, false, false, false, false, false)

        findViewById<ImageView>(R.id.btn_beer).setOnClickListener {
            if (cnt >= 3) {
                Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                if (checkedArray[0]) {
                    checkedArray[0] = false
                    it.alpha = 1.0F
                    cnt--
                } else {
                    checkedArray[0] = true
                    it.alpha = 0.4F
                    cnt++
                }

            }
        }

        findViewById<ImageView>(R.id.btn_soju).setOnClickListener {
            if (cnt >= 3) {
                Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                if (checkedArray[1]) {
                    checkedArray[1] = false
                    it.alpha = 1.0F
                    cnt--
                } else {
                    checkedArray[1] = true
                    it.alpha = 0.4F
                    cnt++
                }

            }
        }

        findViewById<ImageView>(R.id.btn_chungha).setOnClickListener {
            if (cnt >= 3) {
                Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                if (checkedArray[2]) {
                    checkedArray[2] = false
                    it.alpha = 1.0F
                    cnt--
                } else {
                    checkedArray[2] = true
                    it.alpha = 0.4F
                    cnt++
                }

            }
        }

        findViewById<ImageView>(R.id.btn_bokbunja).setOnClickListener {
            if (cnt >= 3) {
                Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                if (checkedArray[3]) {
                    checkedArray[3] = false
                    it.alpha = 1.0F
                    cnt--
                } else {
                    checkedArray[3] = true
                    it.alpha = 0.4F
                    cnt++
                }

            }
        }

        findViewById<ImageView>(R.id.btn_tonic).setOnClickListener {
            if (cnt >= 3) {
                Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                if (checkedArray[4]) {
                    checkedArray[4] = false
                    it.alpha = 1.0F
                    cnt--
                } else {
                    checkedArray[4] = true
                    it.alpha = 0.4F
                    cnt++
                }

            }
        }

        findViewById<ImageView>(R.id.btn_coke).setOnClickListener {
            if (cnt >= 3) {
                Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                if (checkedArray[5]) {
                    checkedArray[5] = false
                    it.alpha = 1.0F
                    cnt--
                } else {
                    checkedArray[5] = true
                    it.alpha = 0.4F
                    cnt++
                }

            }
        }

        findViewById<ImageView>(R.id.btn_cider).setOnClickListener {
            if (cnt >= 3) {
                Toast.makeText(this, "2가지 또는 3가지 종류를 선택하세요.", Toast.LENGTH_SHORT).show()
            } else {
                if (checkedArray[6]) {
                    checkedArray[6] = false
                    it.alpha = 1.0F
                    cnt--
                } else {
                    checkedArray[6] = true
                    it.alpha = 0.4F
                    cnt++
                }
            }
        }
    }


}