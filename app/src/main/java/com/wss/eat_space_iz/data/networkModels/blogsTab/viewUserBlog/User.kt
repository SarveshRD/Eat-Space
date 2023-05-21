package com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("mobile")
    val mobile: String,
    @SerializedName("name")
    val name: String
)