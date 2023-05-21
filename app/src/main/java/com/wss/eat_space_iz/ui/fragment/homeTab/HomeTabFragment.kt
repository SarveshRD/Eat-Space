package com.wss.eat_space_iz.ui.fragment.homeTab


import android.view.View
import androidx.fragment.app.viewModels
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouData
import com.wss.eat_space_iz.data.networkModels.homeTab.recommendedForYou.RecommendedForYouResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.viewGlobalCategory.ViewGlobalCategoryData
import com.wss.eat_space_iz.data.networkModels.homeTab.viewGlobalCategory.ViewGlobalCategoryResponse
import com.wss.eat_space_iz.data.networkModels.homeTab.viewPopularNearYou.ViewPopularNearYouData
import com.wss.eat_space_iz.data.networkModels.homeTab.viewPopularNearYou.ViewPopularNearYouResponse
import com.wss.eat_space_iz.databinding.FragmentHomeTabBinding
import com.wss.eat_space_iz.ui.adapter.homeTab.categories.CategoriesAdapter
import com.wss.eat_space_iz.ui.adapter.homeTab.popularNearYou.PopularNearYouAdapter
import com.wss.eat_space_iz.ui.adapter.homeTab.recommended.RecommendedAdapter
import com.wss.eat_space_iz.ui.common.ApiRenderState
import com.wss.eat_space_iz.ui.fragment.base.BaseFrag
import com.wss.eat_space_iz.ui.viewModel.homeTab.HomeTabViewModel
import com.wss.eat_space_iz.utils.Layouts
import com.wss.eat_space_iz.utils.Strings
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeTabFragment :
    BaseFrag<FragmentHomeTabBinding, HomeTabViewModel>(Layouts.fragment_home_tab) {

    private lateinit var mPopularNearYouAdapter: PopularNearYouAdapter
    private lateinit var mPopularNearYouDataList: List<ViewPopularNearYouData>

    private lateinit var mCategoriesAdapter: CategoriesAdapter
    private lateinit var mCategoriesDataList: List<ViewGlobalCategoryData>

    private lateinit var mRecommendedAdapter: RecommendedAdapter
    private lateinit var mRecommendedDataList: List<RecommendedForYouData>


    override val hasProgress: Boolean = false
    override fun getViewBinding() = FragmentHomeTabBinding.inflate(layoutInflater)
    override val vm: HomeTabViewModel by viewModels()


    private var lat:String ="51.50998"
    private var long:String ="-0.1337"
    private var userId:String = "4"

    override fun init() {
        setUpListener()
        popularNearYou(lat,long)
        viewGlobalCategories()
        viewRecommended(userId)
    }

    private fun popularNearYou(lat : String, long : String) {
        vm.viewPopularNearYou(lat,long)
    }

    private fun viewGlobalCategories()
    {
        vm.viewGlobalCategories()
    }
    private fun viewRecommended(userId:String)
    {
        vm.viewRecommended(userId)
    }

    private fun setUpListener() {
        with(binding) {
        }
    }

    override fun renderState(apiRenderState: ApiRenderState) {
        when (apiRenderState) {
            is ApiRenderState.Loading -> {
                showProgress()
            }
            is ApiRenderState.ApiSuccess<*> -> {

                when (apiRenderState.result) {
                    is ViewPopularNearYouResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    setupPopularNearYouRecyclerView(model.data)
                                }
                                else -> {}
                            }
                        }
                    }

                    is ViewGlobalCategoryResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    setupCategoriesRecyclerView(model.data)
                                }
                                else -> {}
                            }
                        }
                    }

                    is RecommendedForYouResponse -> {
                        val model = apiRenderState.result
                        model.status.let {
                            when (it) {
                                getString(Strings.api_success_status) -> {
                                    setupRecommendedRecyclerView(model.data)
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

    override fun onClick(v: View) {
        super.onClick(v)
        with(binding)
        {
            when (v) {

            }
        }
    }


    private fun setupPopularNearYouRecyclerView(data: List<ViewPopularNearYouData>){
        mPopularNearYouDataList = data
        if (mPopularNearYouDataList.isNotEmpty()) {
            mPopularNearYouAdapter = PopularNearYouAdapter(data)
            binding.homePopularNearYou.rvPopularNearYou.adapter = mPopularNearYouAdapter
        }
    }

    private fun setupCategoriesRecyclerView(data: List<ViewGlobalCategoryData>){
        mCategoriesDataList = data
        if (mCategoriesDataList.isNotEmpty()) {
            mCategoriesAdapter = CategoriesAdapter(data)
            binding.homeCategories.rvCategories.adapter = mCategoriesAdapter
        }
    }

    private fun setupRecommendedRecyclerView(data: List<RecommendedForYouData>){
        mRecommendedDataList = data
        if (mRecommendedDataList.isNotEmpty()) {
            mRecommendedAdapter = RecommendedAdapter(data)
            binding.homeRecommended.rvRecommended.adapter = mRecommendedAdapter
        }
    }
}