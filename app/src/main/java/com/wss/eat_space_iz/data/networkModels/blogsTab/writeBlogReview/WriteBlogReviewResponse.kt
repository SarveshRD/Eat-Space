package com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview


import com.google.gson.annotations.SerializedName

data class WriteBlogReviewResponse(
    @SerializedName("message")
    val data: WriteBlogReviewData,
    @SerializedName("status")
    val status: String
)