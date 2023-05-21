package com.wss.eat_space_iz.data.networkModels.blogsTab.deleteBlogReview


import com.google.gson.annotations.SerializedName

data class DeleteBlogReviewResponse(
    @SerializedName("message")
    val data: String,
    @SerializedName("status")
    val status: String
)