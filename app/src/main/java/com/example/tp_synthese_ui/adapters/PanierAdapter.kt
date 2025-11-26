package com.example.tp_synthese_ui.adapters

import android.annotation.SuppressLint
import android.graphics.Paint
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_synthese_ui.Produit
import com.example.tp_synthese_ui.R
import com.example.tp_synthese_ui.panierproduits

class PanierRecyclerAdapter(
    private val productsMap: MutableMap<Produit, Int>,
    private val onItemChanged: () -> Unit
) : RecyclerView.Adapter<PanierRecyclerAdapter.ProduitViewHolder>() {

    private var productList = productsMap.keys.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.panier_item, parent, false)
        return ProduitViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProduitViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val product = productList[position]
        val quantity = productsMap[product] ?: 0

        holder.image.setImageResource(product.imageRes)
        holder.title.text = product.title
        holder.price.text = "%.2f".format(product.price)+"DH"

        val oldPriceValue = product.oldprice
        if (oldPriceValue > product.price) {
            holder.oldPrice.visibility = View.VISIBLE
            holder.oldPrice.text = "%.2f".format(oldPriceValue)+"DH"
            holder.oldPrice.paintFlags = holder.oldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.oldPrice.visibility = View.GONE
        }

        holder.textWatcher?.let { holder.nbProds.removeTextChangedListener(it) }

        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val entered = s.toString().toIntOrNull() ?: 1
                if (entered < 1) {
                    holder.nbProds.setText("1")
                    holder.nbProds.setSelection(holder.nbProds.text.length) // move cursor to end
                    Toast.makeText(holder.itemView.context, "Minimum quantity is 1", Toast.LENGTH_SHORT).show()
                }
                productsMap[product] = entered
                onItemChanged()
            }
        }

        holder.textWatcher = watcher
        holder.nbProds.setText(quantity.toString())
        holder.nbProds.addTextChangedListener(watcher)

        holder.removebtn.setOnClickListener {
            productsMap.remove(product)

            val newList = productsMap.keys.toList()

            notifyItemRemoved(position)

            productList = newList

            notifyItemRangeChanged(position, itemCount)

            onItemChanged()
        }
    }

    override fun getItemCount(): Int = productList.size

    class ProduitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.productImage)
        val title: TextView = itemView.findViewById(R.id.productTitle)
        val price: TextView = itemView.findViewById(R.id.productPrice)
        val oldPrice: TextView = itemView.findViewById(R.id.OldPrice)
        val nbProds: EditText = itemView.findViewById(R.id.nbprods)
        val removebtn: Button = itemView.findViewById(R.id.remove)
        var textWatcher: TextWatcher? = null
    }

    fun clearAll() {
        productsMap.clear()
        productList = productsMap.keys.toList()
        notifyDataSetChanged()
    }

}
