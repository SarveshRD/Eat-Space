package com.wss.eat_space_iz.repository.blogsTab

import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogRequest
import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.ViewFollowingFollowerResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.ViewUserBlogResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteResponse
import com.wss.eat_space_iz.network.ApiService
import com.wss.eat_space_iz.repository.base.ApiResult
import com.wss.eat_space_iz.repository.base.BaseRepo
import javax.inject.Inject

class ViewOthersBlogRepository
@Inject constructor(private val apiCall: ApiService): BaseRepo(){
    suspend fun viewUserBlog(
        userId: String,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): ViewUserBlogResponse? {
        return with(apiCall(executable = {
            apiCall.viewUserBlog(userId = userId)
        })) {
            if (data == null) onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

    suspend fun viewFollowingFollowers(
        userId: String,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): ViewFollowingFollowerResponse? {
        return with(apiCall(executable = {
            apiCall.viewFollowingFollowers(userId = userId)
        })) {
            if (data == null) onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

    suspend fun upvoteBlog(
        upvoteBlogRequest: UpvoteBlogRequest,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): UpvoteBlogResponse? {
        return with(apiCall(executable = {
            apiCall.upvoteBlog(upvoteBlogRequest = upvoteBlogRequest)
        })) {
            if (data == null) onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }

    suspend fun removeUpvote(
        removeUpvoteRequest: RemoveUpvoteRequest,
        onError: ((ApiResult<Any>) -> Unit)?,
    ): RemoveUpvoteResponse? {
        return with(apiCall(executable = {
            apiCall.removeUpvote(removeUpvoteRequest = removeUpvoteRequest)
        })) {
            if (data == null) onError?.invoke(ApiResult(null, resultType, error, resCode = resCode))
            data
        }
    }
}