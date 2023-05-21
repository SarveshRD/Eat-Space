package com.wss.eat_space_iz.ui.adapter.blogTab.otherWall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wss.eat_space_iz.R
import com.wss.eat_space_iz.data.networkModels.blogsTab.viewUserBlog.Blog
import com.wss.eat_space_iz.databinding.CustomOtherWallListItemLayoutBinding
import com.wss.eat_space_iz.utils.Drawables
import com.wss.eat_space_iz.utils.Layouts
import kotlin.properties.Delegates

class OtherWallAdapter(private val mOtherWall: List<Blog>, private val mUserId: String) :
    RecyclerView.Adapter<OtherWallAdapter.MyViewHolder>() {

    companion object {
        private var onItemClickListener: OnItemClickListener? = null
    }

    private lateinit var binding: CustomOtherWallListItemLayoutBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            Layouts.custom_other_wall_list_item_layout,
            parent,
            false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val otherWall = mOtherWall[position]
        val comments = otherWall.comments
        with(binding) {
            ivFood.load(otherWall.restaurantLogo) {
                placeholder(Drawables.ic_placeholder)
                error(Drawables.ic_placeholder)
            }
            tvFoodName.text = otherWall.restaurantName
            tvRestaurantAddress.text = otherWall.restaurantCity
            tvUpvotesCount.text = buildString {
                append(otherWall.upvoteCount)
                append(" Upvotes")
            }
            tvCommentCount.text = buildString {
                append(otherWall.comments.size)
                append(" Comments")
            }
            tvFoodPostDiscription.text = otherWall.body
            rtRestaurant.rating = otherWall.rating.toFloat()

            if (otherWall.upvote.contains(mUserId)) {
                imgBtnUpvote.setImageResource(R.drawable.upvote_fill_icon)
                tvComment.setTextColor(ContextCompat.getColor(context,
                    R.color.like_comment_fill_text_color))
            } else {
                imgBtnUpvote.setImageResource(R.drawable.upvote_icon)
                tvComment.setTextColor(ContextCompat.getColor(context,
                    R.color.like_comment_un_fill_text_color))
            }

            /*if (comments.any { it.id == mUserId.toInt() })
                imgBtnComment.setImageResource(R.drawable.comment_fill_icon)
            else
                imgBtnComment.setImageResource(R.drawable.comment_icon)*/

            /*imgBtnUpvote.setImageResource(if (otherWall.upvote.contains(mUserId.toInt())) R.drawable.upvote_fill_icon
            else R.drawable.upvote_icon)

            imgBtnComment.setImageResource(if (comments.any { it.id == mUserId.toInt() }) R.drawable.comment_fill_icon
            else R.drawable.comment_icon)


            tvComment.setTextColor(
                if (comments.any { it.id == mUserId.toInt() })
                    ContextCompat.getColor(context, R.color.like_comment_fill_text_color)
                else ContextCompat.getColor(context, R.color.like_comment_un_fill_text_color))
*/
        }
    }

    override fun getItemCount(): Int {
        return mOtherWall.size
    }

    class MyViewHolder(val binding: CustomOtherWallListItemLayoutBinding) :
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
        OtherWallAdapter.onItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClickUpVoteDownVote(position: Int, v: View)
        fun onItemClickCommentPost(position: Int, v: View)
        fun onItemClickSharePost(position: Int, v: View)
        fun onItemClickOtherProfileDetails(position: Int, v: View)
    }

}

