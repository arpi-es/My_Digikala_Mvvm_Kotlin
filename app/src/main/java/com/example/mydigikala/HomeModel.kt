package com.example.mydigikala

data class HomeModel(
    val ProductNew: List<ProductNew>,
    val ProductPourforsh: List<ProductPourforsh>,
    val Slider: List<Slider>,
    val SliderMini: List<SliderMini>,
    val Status: String
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

data class SliderMini(
    val date: String,
    val idslider: String,
    val iduser: String,
    val layer: String,
    val name: String,
    val pic: String,
    val type: String,
    val `val`: String
)

data class ProductNew(
    val garanti: String,
    val idcolor: String,
    val idproduct: String,
    val idstore: String,
    val name: String,
    val pic: String,
    val price_sale: String
)

data class ProductPourforsh(
    val garanti: String,
    val idcolor: String,
    val idproduct: String,
    val idstore: String,
    val name: String,
    var pic: String,
    val price_sale: String
)