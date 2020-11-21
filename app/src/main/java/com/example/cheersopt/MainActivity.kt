package com.example.cheersopt

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var cnt = 0
    var checkedArray = arrayListOf<Boolean>(false, false, false, false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickDrinkBtn()
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
}