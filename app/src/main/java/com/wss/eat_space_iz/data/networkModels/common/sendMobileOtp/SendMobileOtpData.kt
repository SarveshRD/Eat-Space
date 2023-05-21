package com.wss.eat_space_iz.data.networkModels.common.sendMobileOtp

import com.google.gson.annotations.SerializedName

data class SendMobileOtpData(
    @SerializedName("otp") var otp: Int
)