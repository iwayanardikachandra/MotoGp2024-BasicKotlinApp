package com.example.motogpapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvRiders: RecyclerView
    private val list = ArrayList<Rider>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRiders = findViewById(R.id.rv_riders)
        rvRiders.setHasFixedSize(true)

        list.addAll(getListRiders())
        showRecyclerList()
    }

    //About
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                // Intent Ke About Activity
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListRiders(): ArrayList<Rider> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listRider = ArrayList<Rider>()
        for (i in dataName.indices) {
            val hero = Rider(dataName[i], dataDescription[i], dataPhoto[i])
            listRider.add(hero)
        }
        return listRider
    }

    private fun showRecyclerList() {
        rvRiders.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListRiderAdapter(list)
        rvRiders.adapter = listHeroAdapter
    }
}