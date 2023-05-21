package com.wss.eat_space_iz.ui.fragment.blogsTab

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.Blog
import com.wss.eat_space_iz.databinding.FragmentViewBlogDetailsBinding
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.viewModel.blogsTab.ViewBlogDetailsViewModel
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.utils.Drawables
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewBlogDetailsFragment :
    BaseFrag<FragmentViewBlogDetailsBinding, ViewBlogDetailsViewModel>(Layouts.fragment_view_blog_details) {

    private val args: ViewBlogDetailsFragmentArgs by navArgs()
    private var mBlogImages: List<String>? = null
    private lateinit var mBlogDetails: Blog
    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentViewBlogDetailsBinding.inflate(layoutInflater)
    override val vm: ViewBlogDetailsViewModel by viewModels()

    override fun init() {
        mBlogDetails = args.BlogsDetails
        setUpListener()
        setBlogsData(mBlogDetails)
    }

    private fun setBlogsData(mBlogDetails: Blog) {
        //mBlogImages = mBlogDetails.images
        with(binding) {
            civFollowerProfile.load(mBlogDetails.userProfilePic) {
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            ivFood.load(mBlogDetails.userProfilePic) {
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            tvFollowerName.text = mBlogDetails.userName
            tvBlogTime.text = mBlogDetails.createdAt
            rtExperience.rating = mBlogDetails.rating.toFloat()
            tvBlogContentTitle.text = mBlogDetails.title
            tvBlogContentDiscription.text = mBlogDetails.body


        }

    }

    private fun setUpListener() {
        with(binding) {
            ivFoodLeftArrow.setOnClickListener(this@ViewBlogDetailsFragment)
            ivFoodRightArrow.setOnClickListener(this@ViewBlogDetailsFragment)
        }
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {

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

    override fun onClick(v: View) {
        super.onClick(v)
        with(binding) {
            when (v) {
                ivFoodLeftArrow -> {

                }
                ivFoodRightArrow -> {

                }
            }
        }
    }
}
