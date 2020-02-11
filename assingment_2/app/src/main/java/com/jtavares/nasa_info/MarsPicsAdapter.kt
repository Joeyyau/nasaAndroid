package com.jtavares.nasa_info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop

class MarsPicsAdapter(
    private var marsPics: List<MarsPics>,
    private val onMarsPicClick:(picture: MarsPics) -> Unit
) : RecyclerView.Adapter<MarsPicsAdapter.MarsPicsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): MarsPicsViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_marspics, parent, false)
        return MarsPicsViewHolder(view)

    }

    override fun getItemCount(): Int = marsPics.size

    override fun onBindViewHolder(holder: MarsPicsViewHolder, position: Int) {
        holder.bind(marsPics[position])
    }

    fun updateMarsPics(marsPics: List<MarsPics>){
        this.marsPics = marsPics
        notifyDataSetChanged()
    }

    inner class MarsPicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val poster: ImageView = itemView.findViewById(R.id.item_mars_picture)

        fun bind(marsPics: MarsPics){
            Glide.with(itemView)
                .load(marsPics.source)
                .transform(CenterCrop())
                .into(poster)
            itemView.setOnClickListener{ onMarsPicClick.invoke(marsPics)}
        }
    }

}
