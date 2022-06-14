package com.example.checkinghomework.ui.screens.profile.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkinghomework.R
import com.example.checkinghomework.model.ProfileModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileAdapter @Inject constructor()
    : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    private val profileList = mutableListOf<ProfileModel>()

    var row: Int = 0

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun loadCard(list: List<ProfileModel>) {
        profileList.clear()
        profileList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.profile_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = profileList[position]

        holder.titleText.text = currentItem.title

        setCardViewAction(holder, position)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setCardViewAction(holder: ViewHolder, position: Int) {
        holder.cardView.setOnClickListener {
            onItemClickListener?.let { it1 -> it1(position) }
            row = position
            notifyDataSetChanged()
        }
        if (row == position) {
            holder.cardView.elevation = 0F
            holder.cardView.setBackgroundResource(R.drawable.bg_cardview_text_stroke)
            holder.titleText.setTextColor(Color.parseColor("#ffffff"))
        } else {
            holder.cardView.elevation = 0F
            holder.cardView.setBackgroundResource(R.drawable.bg_cardview)
            holder.titleText.setTextColor(Color.parseColor("#000000"));
        }
    }

    override fun getItemCount(): Int {
       return profileList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cv_selection)
        val titleText: TextView = itemView.findViewById(R.id.tv_title)
    }

}