package com.wss.eat_space_iz.ui.fragment.blogsTab

import android.graphics.Typeface
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.wss.eat_space_iz.databinding.FragmentBlogsTabBinding
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.google.gson.Gson
import com.wss.eat_space_iz.R
import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogRequest
import com.wss.eat_space_iz.data.networkModels.blogsTab.upvoteBlog.UpvoteBlogResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.Follower
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.Following
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewFollowingFollower.ViewFollowingFollowerResponse
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.Blog
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.ViewUserBlogData
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.ViewUserBlogResponse
import com.wss.eat_space_iz.data.networkModels.loginSignUp.userLogin.UserLoginData
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteRequest
import com.wss.eat_space_iz.data.networkModels.profileTab.removeUpvote.RemoveUpvoteResponse
import com.wss.eat_space_iz.ui.adapter.blogTab.myBlogs.MyBlogsAdapter
import com.wss.eat_space_iz.ui.adapter.blogTab.otherWall.OtherWallAdapter
import com.wss.eat_space_iz.ui.viewModel.blogsTab.BlogsTabViewModel
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Strings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogsTabFragment :
    BaseFrag<FragmentBlogsTabBinding, BlogsTabViewModel>(Layouts.fragment_blogs_tab) {

    companion object {
        const val MY_BLOGS = "myBlogs"
        const val OTHER_WALL = "OtherWall"
    }

    private var mUserId: String? = null
    private var mUserProfileDetails: String? = null
    private var mUserProfileData: UserLoginData? = null
    private var mUserFollower: List<Follower>? = null
    private var mUserFollowing: List<Following>? = null
    private var mMyBlogs: List<Blog>? = null
    private var mOtherWall: List<Blog>? = null
    private var mViewUserBlogData: ViewUserBlogData? = null
    private var mMyBlogsAdapter: MyBlogsAdapter? = null
    private var mOtherWallAdapter: OtherWallAdapter? = null
    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentBlogsTabBinding.inflate(layoutInflater)
    override val vm: BlogsTabViewModel by viewModels()

    override fun init() {
        mUserId = prefs.userId
        mUserProfileDetails = prefs.userProfileDetails
        mUserProfileData = Gson().fromJson(mUserProfileDetails, UserLoginData::class.java)
        setUpUserProfileData(mUserProfileData)
        setUpListener()
        mUserId?.let {
            viewUserBlogReq(it)
            viewFollowingFollowersReq(it)
        }


    }

    private fun setUpUserProfileData(data: UserLoginData?) {
        with(binding) {
            if (data != null) {
                tvProfieName.text = data.fullName
                tvMobileEmail.text = buildString {
                    append(data.mobileNo)
                    append(" ")
                    append(data.email)
                }
                civProfile.load(prefs.userProfilePic) {
                    placeholder(Drawables.ic_placeholder)
                    error(Drawables.ic_placeholder)
                }
            }
        }
    }

    private fun viewFollowingFollowersReq(userId: String) {
        vm.viewFollowingFollowers(userId = "02")
    }

    private fun viewUserBlogReq(userId: String) {
        vm.viewUserBlog(userId = "02")
    }

    private fun upvoteDownVoteBlogReq(position: Int, blogType: String) {
        when (blogType) {
            MY_BLOGS -> {
                mMyBlogs?.let { myBlogs ->
                    when {
                        myBlogs[position].upvote.contains(prefs.userId/*?.toInt()*/) -> {
                            val upvoteBlogRequest = UpvoteBlogRequest(
                                blogId = myBlogs[position].id,
                                userId = prefs.userId!!.toInt()
                            )
                            vm.upvoteBlog(upvoteBlogRequest)
                        }
                        else -> {
                            val removeUpvoteRequest = RemoveUpvoteRequest(
                                blogId = myBlogs[position].id,
                                userId = prefs.userId!!.toInt()
                            )
                            vm.removeUpvote(removeUpvoteRequest)
                        }
                    }
                }
            }
            OTHER_WALL -> {
                mOtherWall?.let { otherWall ->
                    when {
                        otherWall[position].upvote.contains(prefs.userId/*?.toInt()*/) -> {
                            val upvoteBlogRequest = UpvoteBlogRequest(
                                blogId = otherWall[position].id,
                                userId = prefs.userId!!.toInt()
                            )
                            vm.upvoteBlog(upvoteBlogRequest)
                        }
                        else -> {
                            val removeUpvoteRequest = RemoveUpvoteRequest(
                                blogId = otherWall[position].id,
                                userId = prefs.userId!!.toInt()
                            )
                            vm.removeUpvote(removeUpvoteRequest)
                        }
                    }
                }
            }
        }
    }


    private fun setUpListener() {
        with(binding) {
            tvFollowers.setOnClickListener(this@BlogsTabFragment)
            tvFollowing.setOnClickListener(this@BlogsTabFragment)
            tvFollowersCount.setOnClickListener(this@BlogsTabFragment)
            tvFollowingCount.setOnClickListener(this@BlogsTabFragment)
            tvWall.setOnClickListener(this@BlogsTabFragment)
            tvMyBlogs.setOnClickListener(this@BlogsTabFragment)
            fabAddReview.setOnClickListener(this@BlogsTabFragment)
        }
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
                                    mOtherWall = model.data.blogs
                                    mOtherWall?.let { otherWall ->
                                        setUpOtherBlogRecycler(otherWall)
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

    private fun setUpOtherBlogRecycler(otherWall: List<Blog>) {
        mOtherWallAdapter = mUserId?.let { OtherWallAdapter(otherWall, it) }
        binding.rvOtherWall.adapter = mOtherWallAdapter
        mOtherWallAdapter!!.setOnItemClickListener(object :
            OtherWallAdapter.OnItemClickListener {
            override fun onItemClickUpVoteDownVote(position: Int, v: View) {
                upvoteDownVoteBlogReq(position, OTHER_WALL)
            }

            override fun onItemClickCommentPost(position: Int, v: View) {
                viewBlogsDetails(position, OTHER_WALL)
            }

            override fun onItemClickSharePost(position: Int, v: View) {

            }

            override fun onItemClickOtherProfileDetails(position: Int, v: View) {
                viewOtherUserProfile(position)
            }
        })
    }

    private fun viewOtherUserProfile(position: Int) {
        val otherBlogsPost = mOtherWall?.get(position)
        val otherUserId = otherBlogsPost?.user.toString()
        val otherUserProfilePic = otherBlogsPost?.userProfilePic
        val otherUserFullName = otherBlogsPost?.userName
        if (otherUserId != mUserId) {
            otherUserFullName?.let { otherUserFullName ->
                if (otherUserProfilePic != null) {
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToViewOthersBlogFragment(
                            userId = otherUserId,
                            userName = otherUserFullName,
                            userProfilePic = otherUserProfilePic)

                    findNavController().navigate(action)
                }
            }

        }

    }

    private fun viewBlogsDetails(position: Int, blogType: String) {
        when (blogType) {
            MY_BLOGS -> {
                mMyBlogs?.let { myBlogs ->
                    val blogDetail = myBlogs[position]
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToViewBlogDetailsFragment(
                            blogDetail)
                    findNavController().navigate(action)
                }
            }
            OTHER_WALL -> {
                mOtherWall?.let { otherWall ->
                    val blogDetail = otherWall[position]
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToViewBlogDetailsFragment(
                            blogDetail)
                    findNavController().navigate(action)
                }
            }
        }

    }

    private fun setUpMyBlogRecycler(myBlogs: List<Blog>) {
        mMyBlogsAdapter = mUserId?.let { MyBlogsAdapter(myBlogs, it) }
        binding.rvMyWall.adapter = mMyBlogsAdapter
        mMyBlogsAdapter!!.setOnItemClickListener(object :
            MyBlogsAdapter.OnItemClickListener {
            override fun onItemClickUpVoteDownVote(position: Int, v: View) {
                upvoteDownVoteBlogReq(position, MY_BLOGS)
            }

            override fun onItemClickCommentPost(position: Int, v: View) {
                viewBlogsDetails(position, OTHER_WALL)
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
                tvFollowers -> {
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(
                            isFollower = true)
                    findNavController().navigate(action)
                }
                tvFollowing -> {
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(
                            isFollower = false)
                    findNavController().navigate(action)
                }
                tvFollowersCount -> {
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(
                            isFollower = true)
                    findNavController().navigate(action)
                }
                tvFollowingCount -> {
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToFollowerAndFollowingFragment(
                            isFollower = false)
                    findNavController().navigate(action)
                }
                tvWall -> {
                    switchOtherWalls()
                }
                tvMyBlogs -> {
                    switchMyBlogs()
                }
                fabAddReview -> {
                    val action =
                        BlogsTabFragmentDirections.actionBlogsTabFragmentToAddReviewFragment()
                    findNavController().navigate(action)
                }
                else -> {}
            }
        }
    }

    private fun switchMyBlogs() {
        with(binding) {
            rvOtherWall.visibility = View.GONE
            rvMyWall.visibility = View.VISIBLE
            tvMyBlogs.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.tv_follow_type_bg)
            tvWall.background = null
            val typeface: Typeface? = ResourcesCompat.getFont(requireContext(), R.font.gilroy_bold)
            tvMyBlogs.typeface = typeface
            mMyBlogs = mOtherWall?.filter { blog -> blog.user != "02".toInt() }
            mMyBlogs?.let { setUpMyBlogRecycler(it) }
        }
    }

    private fun switchOtherWalls() {
        with(binding) {
            rvMyWall.visibility = View.GONE
            rvOtherWall.visibility = View.VISIBLE
            tvWall.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.tv_follow_type_bg)
            tvMyBlogs.background = null
            val typeface: Typeface? = ResourcesCompat.getFont(requireContext(), R.font.gilroy_bold)
            tvWall.typeface = typeface
            mOtherWall?.let { setUpOtherBlogRecycler(it) }
        }
    }
}