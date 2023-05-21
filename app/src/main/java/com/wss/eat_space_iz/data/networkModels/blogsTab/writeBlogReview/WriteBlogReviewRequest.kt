package com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview


import com.google.gson.annotations.SerializedName

data class WriteBlogReviewRequest(
    @SerializedName("body")
    val body: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("on_wall")
    val onWall: Boolean = true,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("report_comment")
    val reportComment: String = "",
    @SerializedName("reported")
    val reported: Boolean = false,
    @SerializedName("restaurant")
    val restaurant: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: Int,
    @SerializedName("valid")
    val valid: Boolean = true,
)