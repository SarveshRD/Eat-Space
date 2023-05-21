package com.wss.eat_space_iz.data.networkModels.loginSignUp.createUserAccount


import com.google.gson.annotations.SerializedName

data class CreateUserAccountResponse(
    @SerializedName("message")
    var data: CreateUserAccountData,
    @SerializedName("status")
    var status: String
)