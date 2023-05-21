package com.wss.eat_space_iz.ui.fragment.blogsTab

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.Follower
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.Following
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.ViewFollowingFollowerResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.Blog
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.ViewUserBlogData
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.ViewUserBlogResponse
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteResponse
import com.wss.eat_space_iz.databinding.FragmentViewOthersBlogBinding
import com.wss.eat_space_iz.ui.adapter.blogTab.otherWall.OtherWallAdapter
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.blogsTab.ViewOthersBlogViewModel
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Strings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewOthersBlogFragment :
    BaseFrag<FragmentViewOthersBlogBinding, ViewOthersBlogViewModel>(Layouts.fragment_view_others_blog) {

    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentViewOthersBlogBinding.inflate(layoutInflater)
    override val vm: ViewOthersBlogViewModel by viewModels()
    private val args: ViewOthersBlogFragmentArgs by navArgs()
    private var mViewUserBlogData: ViewUserBlogData? = null
    private var mOtherWallBlogs: List<Blog>? = null
    private var mUserId: String? = null
    private var mUserFullName: String? = null
    private var mUserProfilePic: String? = null
    private var mUserFollower: List<Follower>? = null
    private var mUserFollowing: List<Following>? = null
    private var mOtherWallAdapter: OtherWallAdapter? = null

    override fun init() {
        mUserId = args.userId
        mUserFullName = args.userName
        mUserProfilePic = args.userProfilePic
        setUpListener()
        setUpUserProfileData()
        mUserId?.let {
            viewUserBlogReq(it)
            viewFollowingFollowersReq(it)
        }
    }

    private fun setUpListener() {
        with(binding) {
            tvFollowers.setOnClickListener(this@ViewOthersBlogFragment)
            tvFollowing.setOnClickListener(this@ViewOthersBlogFragment)
            tvFollowersCount.setOnClickListener(this@ViewOthersBlogFragment)
            tvFollowingCount.setOnClickListener(this@ViewOthersBlogFragment)
            ivBack.setOnClickListener(this@ViewOthersBlogFragment)
        }
    }

    private fun setUpUserProfileData() {
        with(binding) {
            tvProfieName.text = mUserFullName
            civProfile.load(mUserProfilePic) {
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
        }
    }


    private fun setUpFollowerAndFollowing(
        userFollower: List<Follower>,
        userFollowing: List<Following>,
    ) {
        with(binding) {
            if (userFollower[0].followersCount < 9) tvFollowersCount.text =
                "0" + userFollower[0].followersCount.toString()
            else tvFollowersCount.text = userFollower[0].followersCount.toString()

            if (userFollowing[0].followersCount < 9) tvFollowingCount.text =
                "0" + userFollowing[0].followersCount.toString()
            else tvFollowingCount.text = userFollowing[0].followersCount.toString()

        }
    }

    private fun viewFollowingFollowersReq(userId: String) {
        vm.viewFollowingFollowers(userId = "02")
    }

    private fun viewUserBlogReq(userId: String) {
        vm.viewUserBlog(userId = "02")
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {
                when (apiRenderState.result) {
                    is ViewUserBlogResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    mViewUserBlogData = model.data
                                    mOtherWallBlogs = model.data.blogs
                                    mOtherWallBlogs?.let { myBlogs ->
                                        setUpOtherBlogRecycler(myBlogs)
                                    }
                                }
                                else -> {}
                            }
                        }
                    }
                    is ViewFollowingFollowerResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    mUserFollower = model.data.followers
                                    mUserFollowing = model.data.following
                                    mUserFollower?.let { userFollower ->
                                        mUserFollowing?.let { userFollowing ->
                                            setUpFollowerAndFollowing(userFollower, userFollowing)
                                        }
                                    }
                                }
                                else -> {}
                            }
                        }
                    }
                    is UpvoteBlogResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {

                                }
                                else -> {}
                            }
                        }
                    }
                    is RemoveUpvoteResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {

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

    private fun setUpOtherBlogRecycler(otherWall: List<Blog>) {
        mOtherWallAdapter = mUserId?.let { OtherWallAdapter(otherWall, it) }
        binding.rvOtherWall.adapter = mOtherWallAdapter
        mOtherWallAdapter!!.setOnItemClickListener(object : OtherWallAdapter.OnItemClickListener {
            override fun onItemClickUpVoteDownVote(position: Int, v: View) {
                // upvoteDownVoteBlogReq(position, BlogsTabFragment.OTHER_WALL)
            }

            override fun onItemClickCommentPost(position: Int, v: View) {
                // viewBlogsDetails(position, BlogsTabFragment.OTHER_WALL)
            }

            override fun onItemClickSharePost(position: Int, v: View) {

            }

            override fun onItemClickOtherProfileDetails(position: Int, v: View) {

            }
        })
    }

    override fun onClick(v: View) {
        super.onClick(v)
        with(binding) {
            when (v) {
                ivBack -> {
                    findNavController().popBackStack()
                }
                else -> {}
            }
        }
    }
}

