package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllUser


import com.google.gson.annotations.SerializedName

data class ViewAllUserResponse(
    @SerializedName("message")
    val data: List<ViewAllUserData>,
    @SerializedName("status")
    val status: String
)