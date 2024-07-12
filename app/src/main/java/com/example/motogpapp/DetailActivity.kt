package com.example.motogpapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imageView = findViewById(R.id.action_share)

        val name = intent.getStringExtra("key_name")
        val description = intent.getStringExtra("key_description")
        val photo = intent.getStringExtra("key_photo")

        val imgPhoto: ImageView = findViewById(R.id.image_detail)
        val tvName: TextView = findViewById(R.id.text_name)
        val tvDescription: TextView = findViewById(R.id.text_description)

        tvName.text = name
        tvDescription.text = description

        // Load image using Glide
        Glide.with(this)
            .load(photo)
            .placeholder(R.drawable.motogp) // Placeholder image while loading
            .error(R.drawable.motogp) // Image to display in case of error loading
            .into(imgPhoto)

        // Set OnClickListener for ImageView share
        imageView.setOnClickListener {
            // Buat intent implicit untuk mengirim teks
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name: $description")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, null))
        }
    }
}