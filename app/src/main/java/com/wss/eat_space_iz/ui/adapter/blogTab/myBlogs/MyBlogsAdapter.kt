package com.wss.eat_space_iz.ui.adapter.blogTab.myBlogs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.Blog
import com.wss.eat_space_iz.databinding.CustomMyBlogsListItemLayoutBinding
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts

class MyBlogsAdapter(private val mMyBlogs: List<Blog>, mUserId: String) :
    RecyclerView.Adapter<MyBlogsAdapter.MyViewHolder>() {

    companion object {
        private var onItemClickListener: OnItemClickListener? = null
    }

    private lateinit var binding: CustomMyBlogsListItemLayoutBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            Layouts.custom_my_blogs_list_item_layout,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myBlogs = mMyBlogs[position]
        with(binding) {
            ivFood.load(myBlogs.restaurantLogo) {
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            tvFoodName.text = myBlogs.restaurantName
            tvRestaurantAddress.text = myBlogs.restaurantCity
            tvUpvotesCount.text = "${myBlogs.upvoteCount} Upvotes"
            tvCommentCount.text = "${myBlogs.comments.size} Comments"
            tvFoodPostDiscription.text = myBlogs.body
            rtRestaurant.rating = myBlogs.rating.toFloat()

        }
    }

    override fun getItemCount(): Int {
        return mMyBlogs.size
    }

    class MyViewHolder(val binding: CustomMyBlogsListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {
                tvUpvote.setOnClickListener { v ->
                    onItemClickListener!!.onItemClickUpVoteDownVote(absoluteAdapterPosition, v)
                }
                tvComment.setOnClickListener { v ->
                    onItemClickListener!!.onItemClickCommentPost(absoluteAdapterPosition, v)
                }
                tvShare.setOnClickListener { v ->
                    onItemClickListener!!.onItemClickSharePost(absoluteAdapterPosition, v)
                }
                imgBtnUpvote.setOnClickListener { v ->
                    onItemClickListener!!.onItemClickUpVoteDownVote(absoluteAdapterPosition, v)
                }
                imgBtnComment.setOnClickListener { v ->
                    onItemClickListener!!.onItemClickCommentPost(absoluteAdapterPosition, v)
                }
                imgBtnShare.setOnClickListener { v ->
                    onItemClickListener!!.onItemClickSharePost(absoluteAdapterPosition, v)
                }
                ivFood.setOnClickListener { v ->
                    onItemClickListener!!.onItemClickOtherProfileDetails(absoluteAdapterPosition, v)
                }

            }
        }

    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        MyBlogsAdapter.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClickUpVoteDownVote(position: Int, v: View)
        fun onItemClickCommentPost(position: Int, v: View)
        fun onItemClickSharePost(position: Int, v: View)
        fun onItemClickOtherProfileDetails(position: Int, v: View)
    }

}