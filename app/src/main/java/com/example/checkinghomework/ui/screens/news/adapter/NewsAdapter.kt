package com.example.checkinghomework.ui.screens.news.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.checkinghomework.R
import com.example.checkinghomework.model.ArticleModel
import javax.inject.Inject
import javax.inject.Singleton

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var list = mutableListOf<ArticleModel>()
    private var onClickListener: (Int) -> Unit = {}

    fun onClickListener(position: (Int) -> Unit) {
        onClickListener = position
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initAdapter(items: List<ArticleModel>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.title)
        private val author = itemView.findViewById<TextView>(R.id.author)
        private val publishedAt = itemView.findViewById<TextView>(R.id.published_at)

        fun bind(articleModel: ArticleModel) {
            title.text = articleModel.title
            author.text = articleModel.author
            publishedAt.text = articleModel.publishedAt
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            onClickListener(position)
        }
    }

}