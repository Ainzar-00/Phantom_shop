package com.example.tp_synthese_ui

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_synthese_ui.adapters.ProduitRecyclerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class produitsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_produits)



        val paniers = findViewById<BottomNavigationView>(R.id.bottomNav)
        paniers.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.panier -> {
                    startActivity(Intent(this, ActivityPanier::class.java))
                    true
                }
                R.id.profile -> {
                    // Example: open profile activity if you have one
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }

        val categorytextv=findViewById<TextView>(R.id.category)
        val category=intent.getStringExtra("category")
        categorytextv.text=category

        val listproduits: MutableList<Produit> = products[category] as MutableList<Produit>
        val recyclerView = findViewById<RecyclerView>(R.id.productsRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProduitRecyclerAdapter(
            products = listproduits,
            onItemClick = {produit ->
                Toast.makeText(this,produit.title, Toast.LENGTH_LONG).show()
                true
            },
            onItemCheck = {produit ->
                panierproduits.produitsaupanier[produit]=1
                Toast.makeText(this,panierproduits.produitsaupanier.toString(), Toast.LENGTH_LONG).show()
            }
        )



        recyclerView.adapter = adapter


    }
}