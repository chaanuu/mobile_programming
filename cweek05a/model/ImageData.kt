package com.example.cweek05a.model

import androidx.compose.runtime.saveable.listSaver

data class ImageData(
    val image:ImageUri,
    val buttonType: ButtonType = ButtonType.BADGE,
    var likes:Int=0,
    var dislikes:Int=0
){
    companion object{
        val imageSaver= listSaver<ImageData, Any>(
            save={ item ->
                listOf(
                    when(item.image){
                        is ImageUri.ResImage -> item.image.resID
                        is ImageUri.WebImage -> item.image.webUri //is type 식별 기능 + 변환 기능
                    },
                    item.buttonType.name,// 문자열로 저장
                    item.likes,
                    item.dislikes
                )
            },
            restore = { list -> //들어오는 값이 list일 것
                val imgValue = list[0] //이미지 정보
                val image = when(imgValue){ // when 은 모든 경우에 대해서 처리해야한다.
                    is Int -> ImageUri.ResImage(imgValue)
                    is String -> ImageUri.WebImage(imgValue)
                    else -> throw IllegalArgumentException("타입 오류")
                }
                ImageData(
                    image = image,
                    buttonType = ButtonType.valueOf(list[1] as String), // name --> string --> valueof()열거체
                    likes = list[2] as Int,
                    dislikes = list[3] as Int
                )
            }
        )
    }
}


