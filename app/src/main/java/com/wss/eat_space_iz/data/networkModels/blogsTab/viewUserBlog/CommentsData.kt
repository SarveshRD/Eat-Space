package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommentsData(
    @SerializedName("blog")
    var blog: Int,
    @SerializedName("comment")
    var comment: String,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("user")
    var user: Int
):Parcelable