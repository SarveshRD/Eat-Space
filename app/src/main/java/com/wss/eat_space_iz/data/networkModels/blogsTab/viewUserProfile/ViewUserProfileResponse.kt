package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserProfile


import com.google.gson.annotations.SerializedName

data class ViewUserProfileResponse(
    @SerializedName("message")
    val data: ViewUserProfileData,
    @SerializedName("status")
    val status: String
)