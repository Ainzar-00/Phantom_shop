package com.example.tp_synthese_ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_synthese_ui.adapters.PanierRecyclerAdapter
import com.example.tp_synthese_ui.adapters.ProduitRecyclerAdapter
import com.example.tp_synthese_ui.produitsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityPanier : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_panier)

        val confirmbtn=findViewById<Button>(R.id.confirm_button)
        val paniers = findViewById<BottomNavigationView>(R.id.bottomNav)
        paniers.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }

                R.id.profile -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                else -> false
            }
        }

        val total=findViewById<TextView>(R.id.total)
        var listproduits= panierproduits.produitsaupanier

        val recyclerView = findViewById<RecyclerView>(R.id.panierrecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PanierRecyclerAdapter(
            productsMap = listproduits,
            onItemChanged = {
                total.text="Total:${"%.2f".format(listproduits.entries.sumOf { it.key.price * it.value })}DH"
            }
        )

        recyclerView.adapter = adapter

        total.text = "Total:${"%.2f".format(listproduits.entries.sumOf { it.key.price * it.value })}DH"

        confirmbtn.setOnClickListener {
            if(!listproduits.isEmpty()){
                panierproduits.produitsaupanier.clear()

                (adapter as PanierRecyclerAdapter).clearAll()


                total.text= panierproduits.produitsaupanier.toString()

                Toast.makeText(this,"Success", Toast.LENGTH_LONG).show()

            }

            else{
                Toast.makeText(this,"No products in the cart", Toast.LENGTH_LONG).show()
            }
        }

    }
}