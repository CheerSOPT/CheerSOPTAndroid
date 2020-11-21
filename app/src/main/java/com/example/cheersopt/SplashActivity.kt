package com.example.cheersopt

import GifDrawableImageViewTarget
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
/* window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS) */
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen)
        setContentView(R.layout.activity_splash)
        val splash_image = findViewById<ImageView>(R.id.splash_image)

        Glide.with(this).load(R.drawable.and_splash).into(
            GifDrawableImageViewTarget(
                splash_image,
                1
            )
        )

        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 2000)


    }
}