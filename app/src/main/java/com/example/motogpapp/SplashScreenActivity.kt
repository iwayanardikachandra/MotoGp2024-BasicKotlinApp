package com.example.motogpapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set your splash screen layout
        setContentView(R.layout.splash_screen)

        // Optional: Add a timer to automatically navigate to the main activity after a certain duration
        val splashScreenDuration = 3000 // 3 seconds
        val mainActivityIntent = Intent(this, MainActivity::class.java)

        // Delayed navigation to main activity
        val splashScreenTimer = object : Thread() {
            override fun run() {
                try {
                    sleep(splashScreenDuration.toLong())
                    startActivity(mainActivityIntent)
                    finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        splashScreenTimer.start()

    }
}