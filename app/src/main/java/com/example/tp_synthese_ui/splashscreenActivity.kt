package com.example.tp_synthese_ui

import kotlinx.coroutines.*
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Handler

class splashscreenActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.splashscreen)


        val loaderv=findViewById<ImageView>(R.id.loader)

        val animator = ObjectAnimator.ofFloat(loaderv, "rotation", 0f, 360f)
        animator.duration = 1000
        animator.repeatCount = 3
        animator.start()


        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3000)

    }
}