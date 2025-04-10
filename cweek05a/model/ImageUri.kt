package com.example.cweek05a.model

sealed class ImageUri {
    data class ResImage(val resID:Int):ImageUri() //상속
    data class WebImage(val webUri:String):ImageUri()
}