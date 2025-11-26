package com.example.tp_synthese_ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val confirmbtn=findViewById<Button>(R.id.confirm_button)
        val paniers = findViewById<BottomNavigationView>(R.id.bottomNav)
        paniers.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.panier -> {
                    startActivity(Intent(this, ActivityPanier::class.java))
                    true
                }

                R.id.profile -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }


        val audioCategories = listOf(
            Category(productsname.HEADPHONES.name, "High-quality immersive audio experience", R.drawable.audiores, true),
            Category(productsname.CLAVIER.name, "Comfortable and responsive typing performance", R.drawable.clavier, true),
            Category(productsname.MICROPHONES.name, "Clear and professional sound recording", R.drawable.microphones, true),
            Category(productsname.CAMERA.name, "Capture detailed photos and high-definition videos", R.drawable.camera, true),
            Category(productsname.PC.name,"Powerful and reliable performance for all your tasks", R.drawable.pc, true)
            )


        val recyclerView = findViewById<RecyclerView>(R.id.gridcat)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val adapter = CategoryAdapter(audioCategories) { category ->
            val intent = Intent(this, produitsActivity::class.java)
            intent.putExtra("category", category.title)
            startActivity(intent)
        }

        recyclerView.adapter = adapter


    }
}