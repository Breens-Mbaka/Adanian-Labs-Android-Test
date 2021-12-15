package com.breens.adaninalabsandroidtets.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.breens.adaninalabsandroidtets.data.Image
import com.breens.adaninalabsandroidtets.databinding.ItemImageBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    inner class ImageViewHolder(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallBack = object : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Image, newItem: Image) =
            oldItem == oldItem
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemImageBinding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageViewHolder(itemImageBinding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = differ.currentList[position]
        val imageUrl = image.webformatURL
        val user = image.user
        holder.binding.apply {
            imageView.load(imageUrl) {
                transformations(RoundedCornersTransformation(10f))
                crossfade(true)
            }
            userName.text = "User: " + user
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(image)
            }
        }
    }

    override fun getItemCount() = differ.currentList.size

    private var onItemClickListener: ((Image) -> Unit)? = null

    fun setOnItemClickListener(listener: (Image) -> Unit) {
        onItemClickListener = listener
    }

}