package com.example.cweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.cweek05a.R

object ImageListFactory {
    fun makeImageFactory() = mutableStateListOf(
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1), //이미지를 uri객채로 resimage만들어서 넣어준다
            buttonType = ButtonType.ICON,
            likes = 50
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img2), //이미지를 uri객채로 resimage만들어서 넣어준다
            buttonType = ButtonType.BADGE,
            likes = 50,
            dislikes = 5
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img3), //이미지를 uri객채로 resimage만들어서 넣어준다
            buttonType = ButtonType.EMOJI,
            likes = 50,
            dislikes = 5
        )


    )
}