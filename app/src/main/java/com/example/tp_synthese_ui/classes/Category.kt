package com.example.tp_synthese_ui

data class Category(
    val title: String,
    val subtitle: String? = null,
    val imageRes: Int,
    val isNew: Boolean = false
)
