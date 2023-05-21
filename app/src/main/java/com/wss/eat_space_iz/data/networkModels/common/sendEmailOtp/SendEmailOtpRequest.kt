package com.wss.eat_space_iz.data.networkModels.common.sendEmailOtp

import com.google.gson.annotations.SerializedName

data class SendEmailOtpRequest(
    @SerializedName("email") val emailId: String
)