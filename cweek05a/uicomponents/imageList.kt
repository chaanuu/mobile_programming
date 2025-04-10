package com.example.cweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cweek05a.model.ButtonType
import com.example.cweek05a.model.ImageData

@Composable
fun ImageList(modifier: Modifier = Modifier, imageList: MutableList<ImageData>) {
    imageList.forEachIndexed { index, item ->
        when(item.buttonType){
            ButtonType.ICON -> {
                ImageWidthButton(image=item.image) {
                    ButtonWithIcon  (likes = item.likes) {
                        imageList[index]= item.copy(likes=item.likes+1)
                    }
                }
            }
            ButtonType.BADGE -> {
                ImageWidthButton(image=item.image) {
                    ButtonWithBadge(likes = item.likes) {
                        imageList[index]= item.copy(likes=item.likes+1)
                    }
                }

            }
            ButtonType.EMOJI -> {
                ImageWidthButton(image=item.image) {
                    ButtonWithEmoji(
                        likes = item.likes,
                        dislikes = item.dislikes,
                        onClickLikes = {
                            imageList[index]= item.copy(likes=item.likes+1)
                        },
                        onClickDisLikes =
                        {
                            imageList[index]= item.copy(dislikes =item.dislikes+1)
                        }
                    )
                }
            }
        }
    }
}