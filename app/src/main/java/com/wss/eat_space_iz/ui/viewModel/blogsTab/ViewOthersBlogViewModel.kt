package com.wss.eat_space_iz.ui.viewModel.blogsTab


import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteRequest
import com.wss.eat_space_iz.repository.blogsTab.AddReviewRepository
import com.wss.eat_space_iz.repository.blogsTab.ViewOthersBlogRepository
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewOthersBlogViewModel
@Inject constructor(private val repo: ViewOthersBlogRepository) : BaseVM() {

    fun viewUserBlog(userId: String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.viewUserBlog(userId, onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

    fun viewFollowingFollowers(userId: String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.viewFollowingFollowers(userId, onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

    fun upvoteBlog(upvoteBlogRequest: UpvoteBlogRequest) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.upvoteBlog(upvoteBlogRequest, onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

    fun removeUpvote(removeUpvoteRequest: RemoveUpvoteRequest) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.removeUpvote(removeUpvoteRequest, onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }
}