package com.example.bottom

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar

class FrontPageActivity : AppCompatActivity() {
    lateinit var p: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)

        val intent = Intent(this, MainActivity::class.java)

        //progressbar
        p = findViewById(R.id.progressone)

        p.max = 1000
        val c = 1000

        ObjectAnimator.ofInt(p,"progress",c).setDuration(5000).start()



        Handler().postDelayed({
            startActivity(intent)
            finish()
        },5000)



    }
}