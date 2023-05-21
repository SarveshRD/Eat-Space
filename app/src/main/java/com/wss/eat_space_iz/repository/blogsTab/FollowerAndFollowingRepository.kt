package com.wss.eat_space_iz.repository.blogsTab

import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.ViewFollowingFollowerResponse
import com.wss.eat_space_iz.network.ApiService
import com.wss.eat_space_iz.repository.base.ApiResult
import com.wss.eat_space_iz.repository.base.BaseRepo
import javax.inject.Inject

class FollowerAndFollowingRepository
@Inject constructor(private val apiCall: ApiService): BaseRepo() {


    suspend fun viewMyFollowingAndFollowers(
        userId : String,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): ViewFollowingFollowerResponse? {
        return with(apiCall(executable = {
            apiCall.viewFollowingFollowers(userId = userId)
        })) {
            if (data == null)
                onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }


}