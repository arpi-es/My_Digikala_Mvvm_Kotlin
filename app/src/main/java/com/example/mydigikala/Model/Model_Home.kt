package com.example.mydigikala.Model

data class Model_Home(
    val slider: List<Slider>,
    val slider_mini : List<Slider_Mini>,
    val status: String
)
data class Slider(
    val date: String,
    val idslider: String,
    val iduser: String,
    val layer: String,
    val name: String,
    val pic: String,
    val type: String,
    val `val`: String
)

data class Slider_Mini(
    val date: String,
    val idslider: String,
    val iduser: String,
    val layer: String,
    val name: String,
    val pic: String,
    val type: String,
    val `val`: String
)