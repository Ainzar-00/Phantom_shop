package com.example.tp_synthese_ui

data class Produit(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val oldprice: Double=price+price*0.2,
    val imageRes: Int,
    var quantite:Int=0
)

enum class productsname{
    HEADPHONES,CLAVIER,MICROPHONES,CAMERA,PC
}