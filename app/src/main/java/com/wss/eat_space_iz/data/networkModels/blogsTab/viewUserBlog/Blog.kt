package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Blog(
    @SerializedName("body")
    val body: String,
    @SerializedName("comments")
    val comments: List<CommentsData>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("cuisine")
    val cuisine: String,
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
    @SerializedName("restaurant_city")
    val restaurantCity: String,
    @SerializedName("restaurant_logo")
    val restaurantLogo: String,
    @SerializedName("restaurant_name")
    val restaurantName: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("upvote")
    val upvote: List<String>,
    @SerializedName("upvote_count")
    val upvoteCount: Int,
    @SerializedName("user")
    val user: Int,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("user_profile_pic")
    val userProfilePic: String,
    @SerializedName("valid")
    val valid: Boolean,
) : Parcelable