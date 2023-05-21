package com.wss.eat_space_iz.repository.profileTab

import com.wss.eat_space_iz.data.networkModels.common.uploadImage.UploadImageResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.updateUser.UpdateUserRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.updateUser.UpdateUserResponse
import com.wss.eat_space_iz.network.ApiService
import com.wss.eat_space_iz.repository.base.ApiResult
import com.wss.eat_space_iz.repository.base.BaseRepo
import com.wss.eat_space_iz.utils.getFile
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

class ProfileTabRepository
@Inject constructor(private val apiCall: ApiService): BaseRepo() {

    suspend fun uploadImage(
        file: File, folderName: String, onError: ((ApiResult<Any>) -> Unit)?,
    ): UploadImageResponse? {
        return with(apiCall(executable = {
            apiCall.uploadImage(file.getFile("file")!!, folderName = folderName.toRequestBody())
        })) {
            if (data == null) onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

    suspend fun updateUser(
        updateUserRequest: UpdateUserRequest,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): UpdateUserResponse? {
        return with(apiCall(executable = {
            apiCall.updateUser(updateUserRequest)
        })) {
            if (data == null) onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }
}