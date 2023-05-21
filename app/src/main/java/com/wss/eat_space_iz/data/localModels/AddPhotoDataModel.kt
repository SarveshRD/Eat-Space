package com.wss.eat_space_iz.data.localModels

import androidx.annotation.DrawableRes

data class AddPhotoDataModel(
    @DrawableRes val addPhotoImg: Int = 0,
    val imageUrl: String? = null,
    val isImageUrl: Boolean,
)
