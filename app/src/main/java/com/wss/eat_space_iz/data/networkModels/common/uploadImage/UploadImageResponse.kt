package com.wss.eat_space_iz.data.networkModels.common.uploadImage

import com.google.gson.annotations.SerializedName

data class UploadImageResponse(
    @SerializedName("status") val status: String,
    @SerializedName("url") val url: String,
)