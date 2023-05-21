package com.wss.eat_space_iz.data.networkModels.common.sendMobileOtp

import com.google.gson.annotations.SerializedName
import com.wss.eat_space_iz.data.networkModels.common.sendMobileOtp.SendMobileOtpData

data class SendMobileOtpResponse(
    @SerializedName("message") val data: SendMobileOtpData,
    @SerializedName("status") val status: String
)