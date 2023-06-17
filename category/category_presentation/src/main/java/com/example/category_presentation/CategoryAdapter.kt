package com.example.category_presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.category_data.Category
import com.example.category_presentation.databinding.ViewHolderCategoryBinding

class CategoryAdapter(private val list: ArrayList<Category>,   private var listener: OnItemClickListener) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    inner class MyViewHolder(val viewDataBinding:ViewHolderCategoryBinding) : RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ViewHolderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onItemClick(category: Category)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.apply {
            val item = list[position]
            categoryImage.loadImage(item.imageDrawableResId)
            categoryTitle.text = item.text

            if (listener != null) {
                categoryImageCard.setOnClickListener { listener.onItemClick(item) }
            }

        }
    }


    fun ImageView.loadImage(url: Int) {
        val circularProgressDrawable = CircularProgressDrawable(this.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(this).load(url).placeholder(circularProgressDrawable)
            .error(com.google.android.material.R.drawable.mtrl_ic_error).into(this)
    }
}