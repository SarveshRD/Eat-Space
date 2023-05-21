package com.wss.eat_space_iz.data.networkModels.blogsTab.viewAllNotification


import com.google.gson.annotations.SerializedName

data class ViewAllNotificationResponse(
    @SerializedName("message")
    val data: List<Any>,
    @SerializedName("status")
    val status: String
)