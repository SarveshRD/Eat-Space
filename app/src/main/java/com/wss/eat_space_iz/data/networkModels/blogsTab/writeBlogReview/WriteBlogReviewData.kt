package com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview


import com.google.gson.annotations.SerializedName

data class WriteBlogReviewData(
    @SerializedName("body")
    val body: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("on_wall")
    val onWall: Boolean,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("report_comment")
    val reportComment: String,
    @SerializedName("report_time")
    val reportTime: String,
    @SerializedName("reported")
    val reported: Boolean,
    @SerializedName("restaurant")
    val restaurant: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: Int,
    @SerializedName("valid")
    val valid: Boolean
)