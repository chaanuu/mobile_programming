package com.example.cweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cweek05a.model.ImageData
import com.example.cweek05a.model.ImageListFactory

class ImageViewModel: ViewModel() {
    private val _imageList = ImageListFactory.makeImageFactory()
    val imageList: MutableList<ImageData>
        get()=_imageList
}