package com.wss.eat_space_iz.ui.fragment.blogsTab

import android.view.View
import android.view.View.OnTouchListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wss.eat_space_iz.R
import com.wss.eat_space_iz.data.localModels.AddPhotoDataModel
import com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview.WriteBlogReviewRequest
import com.wss.eat_space_iz.data.networkModels.blogsTab.writeBlogReview.WriteBlogReviewResponse
import com.wss.eat_space_iz.data.networkModels.common.uploadImage.UploadImageResponse
import com.wss.eat_space_iz.databinding.FragmentAddReviewBinding
import com.wss.eat_space_iz.ui.adapter.blogTab.addReview.AddPhotoAdapter
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.blogsTab.AddReviewViewModel
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.utils.Strings
import com.wss.eat_space_iz.utils.compress
import com.wss.eat_space_iz.utils.constants.AppConstants
import com.wss.eat_space_iz.utils.logE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File


@AndroidEntryPoint
class AddReviewFragment :
    BaseFrag<FragmentAddReviewBinding, AddReviewViewModel>(Layouts.fragment_add_review) {

    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentAddReviewBinding.inflate(layoutInflater)
    override val vm: AddReviewViewModel by viewModels()
    private var mUserId: String? = null
    private var mAddPhotoAdapter: AddPhotoAdapter? = null
    private var mAddPhotoList: ArrayList<AddPhotoDataModel> = ArrayList()
    private var mAddPhotoUrlsList: ArrayList<String> = ArrayList()
    private var mRating: Int = 0


    override fun init() {
        mUserId = prefs.userId
        setUpListener()
        setUpInitialAddPhotoData()
        setAddPhotoRecyclerView()
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {
                when (apiRenderState.result) {
                    is UploadImageResponse -> {
                        val model = apiRenderState.result
                        model.status?.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    val mProfileUrl = model.url
                                    mAddPhotoList.add(AddPhotoDataModel(0, mProfileUrl, true))
                                    mAddPhotoUrlsList.add(mProfileUrl)
                                    binding.rvAddPhoto.adapter?.notifyDataSetChanged()
                                }
                                else -> {}
                            }
                        }
                    }
                    is WriteBlogReviewResponse -> {
                        val model = apiRenderState.result
                        model.status?.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    successToast("Review Successfully Post")
                                    findNavController().popBackStack(R.id.blogsTabFragment, true)
                                }
                                else -> {}
                            }
                        }
                    }
                }

            }
            is ApiRenderState.ValidationError -> {
                apiRenderState.message?.let {
                    errorToast(getString(it))
                }
            }
            is ApiRenderState.ApiError<*> -> {
                errorToast(apiRenderState.error.toString())
            }
            else -> {}
        }
    }

    private fun setUpInitialAddPhotoData() {
        val addPhotoDataModel = AddPhotoDataModel(R.drawable.add_photo_icon, isImageUrl = false)
        mAddPhotoList.add(addPhotoDataModel)
    }

    private fun setAddPhotoRecyclerView() {
        mAddPhotoAdapter = AddPhotoAdapter(mAddPhotoList)
        binding.rvAddPhoto.adapter = mAddPhotoAdapter
        mAddPhotoAdapter!!.setOnItemClickListener(object : AddPhotoAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, v: View) {
                if (position == 0) {
                    selectImage()
                }
            }

            override fun onItemCLickDelete(position: Int, v: View) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun setUpListener() {
        with(binding) {
            btnSubmitYourReview.setOnClickListener(this@AddReviewFragment)
            imgBtnBack.setOnClickListener(this@AddReviewFragment)
            rtRestaurant.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                mRating = rating.toInt()
                successToast(mRating.toString())
            }
            /*rtRestaurant.setOnTouchListener(OnTouchListener { v, event ->
                val rating: Float = rtRestaurant.rating
                successToast(rating.toString())
                rtRestaurant.onTouchEvent(event)
            })*/
        }
    }

    private fun writeBlogReviewReq(writeBlogReviewRequest: WriteBlogReviewRequest) {
        vm.writeBlogReview(writeBlogReviewRequest)
    }

    private fun uploadImage(file: File) {
        lifecycleScope.launch {
            file.compress(requireContext())
                ?.let { vm.uploadImage(it, AppConstants.App.OTHER_IMAGE_FOLDER) }
        }
    }

    private fun validateWriteBlogReview() {
        with(binding) {
            val blogTitle = tietAddReviewTitle.text.toString().trim()
            val blogDisc = tietWriteAReview.text.toString().trim()
            rtRestaurant.let {
                mRating = it.rating.toInt()
            }
            mUserId?.let { userId ->
                val writeBlogReviewRequest = WriteBlogReviewRequest(
                    title = blogTitle,
                    body = blogDisc,
                    user = 73,
                    restaurant = 14,
                    images = mAddPhotoUrlsList,
                    rating = mRating
                )
                writeBlogReviewReq(writeBlogReviewRequest)
            }
        }

    }


    override fun getSelectedFile(file: File) {
        super.getSelectedFile(file)
        "SELECTED FILE PATH  ${file.path}".logE()
        val filePath: String? = file.path
        if (!filePath.isNullOrEmpty()) {
            uploadImage(file)
        } else {
            errorToast(getString(Strings.error_camera_gallery_file_pick))
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        with(binding) {
            when (v) {
                btnSubmitYourReview -> {
                    validateWriteBlogReview()
                }
                imgBtnBack -> {
                    findNavController().popBackStack()
                }
                else -> {}
            }
        }
    }

}

