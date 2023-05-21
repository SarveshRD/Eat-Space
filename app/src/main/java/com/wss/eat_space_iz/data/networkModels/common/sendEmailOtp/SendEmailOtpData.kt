package com.wss.eat_space_iz.data.networkModels.common.sendEmailOtp

import com.google.gson.annotations.SerializedName

data class SendEmailOtpData(
    @SerializedName("otp") val otp: Int
)