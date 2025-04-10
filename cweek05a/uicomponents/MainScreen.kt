package com.example.cweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val imageViewModel: ImageViewModel = viewModel()

    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageList(imageList = imageList)
        }

    } else {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
        }
    }
}

        /*
        var img1State by rememberSaveable(stateSaver = ImageData.imageSaver) {
            //회전해도 상태를 유지하는 방법
            mutableStateOf(
                ImageData(
                    image = ImageUri.ResImage(R.drawable.img1), //이미지를 uri객채로 resimage만들어서 넣어준다
                    buttonType = ButtonType.BADGE,
                    likes = 50
                )
            )
        }

        var img2State by rememberSaveable(stateSaver = ImageData.imageSaver) {
            //회전해도 상태를 유지하는 방법
            mutableStateOf(
                ImageData(
                    image = ImageUri.ResImage(R.drawable.img2), //이미지를 uri객채로 resimage만들어서 넣어준다
                    buttonType = ButtonType.EMOJI,
                    likes = 50,
                    dislikes = 5
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageWidthButton(image=img1State.image) {
                ButtonWithBadge(likes = img1State.likes) {
                    img1State= img1State.copy(likes=img1State.likes+1) //객체의 일부 속성만 바뀐다고 상태가 바뀌지는 않는다, ++로 하면 값이 바뀌지 않는다
                }
            }

            ImageWidthButton(image=img2State.image) {
                ButtonWithEmoji(
                    likes = img2State.likes,
                    dislikes = img2State.dislikes,
                    onClickLikes = {
                        img2State= img2State.copy(likes=img2State.likes+1)
                    },
                    onClickDisLikes =
                    {
                        img2State= img2State.copy(likes=img2State.dislikes+1)
                    }
                )
            }
        }

    */

