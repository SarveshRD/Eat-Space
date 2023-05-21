package com.wss.eat_space_iz.ui.viewModel.blogsTab


import com.wss.eat_space_iz.repository.blogsTab.ViewBlogDetailsRepository
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewBlogDetailsViewModel
@Inject constructor(private val repo: ViewBlogDetailsRepository) : BaseVM(){

    fun viewFollowingAndFollowers(userId : String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.viewMyFollowingAndFollowers(userId,onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

}