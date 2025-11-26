package com.example.tp_synthese_ui.adapters

import android.graphics.Paint
import android.text.BoringLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_synthese_ui.Produit
import com.example.tp_synthese_ui.R

class ProduitRecyclerAdapter(
    private val products: MutableList<Produit>,
    private val onItemClick: (Produit) -> Boolean,
    private val onItemCheck: (Produit) -> Unit
) : RecyclerView.Adapter<ProduitRecyclerAdapter.ProduitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProduitViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProduitViewHolder, position: Int) {
        val product = products[position]
        holder.title.text = product.title
        holder.description.text = product.description
        holder.price.text = "${product.price}DH"
        holder.image.setImageResource(product.imageRes)
        val formatted = String.format("%.2f", products[position].oldprice)
        holder.oldPrice.paintFlags = holder.oldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.oldPrice.text= "${ formatted }DH"

        holder.itemView.setOnLongClickListener{ product->
            onItemClick(products[position])
        }

        holder.addbtn.setOnClickListener {product->
            onItemCheck(products[position])
        }

    }

    override fun getItemCount(): Int = products.size

    class ProduitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.productImage)
        val title: TextView = itemView.findViewById(R.id.productTitle)
        val description: TextView = itemView.findViewById(R.id.productDescription)
        var price: TextView = itemView.findViewById(R.id.productPrice)

        var oldPrice: TextView=itemView.findViewById(R.id.OldPrice)

        val addbtn: Button=itemView.findViewById(R.id.addbtn)

    }
}
