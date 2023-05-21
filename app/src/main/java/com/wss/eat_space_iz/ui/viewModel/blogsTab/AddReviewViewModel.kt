package com.wss.eat_space_iz.ui.viewModel.blogsTab

import com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview.WriteBlogReviewRequest
import com.wss.eat_space_iz.repository.blogsTab.AddReviewRepository
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.viewModel.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AddReviewViewModel
@Inject constructor(private val repo: AddReviewRepository) : BaseVM() {

    fun uploadImage(file: File, folderName: String) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.uploadImage(
                file,
                folderName,
                onApiError
            )?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

    fun writeBlogReview(writeBlogReviewRequest: WriteBlogReviewRequest) {
        scope {
            state.emit(ApiRenderState.Loading)
            repo.writeBlogReview(writeBlogReviewRequest, onApiError)?.let {
                state.emit(ApiRenderState.ApiSuccess(it))
                return@scope
            }
        }
    }

}