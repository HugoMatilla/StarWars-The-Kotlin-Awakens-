package com.hugomatilla.starwars.ui.activities

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hugomatilla.starwars.R
import com.hugomatilla.starwars.domain.ArticleDomain
import kotlinx.android.synthetic.main.article_list_item.view.*

/**
 * Created by hugomatilla on 28/02/16.
 */

class ArticlesListAdapter(val articlesList: Collection<ArticleDomain>, val itemClick: (ArticleDomain) -> Unit) : RecyclerView.Adapter<ArticlesListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.article_list_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindArticle(articlesList.elementAt(position))
    }

    override fun getItemCount() = articlesList.size

    class ViewHolder(view: View, val itemClick: (ArticleDomain) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindArticle(article: ArticleDomain) {
            with(article) {
                //                com.squareup.picasso.Picasso.with(itemView.ctx).load(thumbnail).into(itemView.articleListImageView)
                Glide.with(itemView.ctx).load(thumbnail).crossFade()
                        //                        .listener(object : RequestListener<String, GlideDrawable> {
                        //                            override fun onResourceReady(p0: GlideDrawable?, p1: String?, p2: Target<GlideDrawable>?, p3: Boolean, p4: Boolean): Boolean {
                        //                                Log.d(javaClass.canonicalName, "Glide: " + p1)
                        //                                Glide.with(itemView.ctx).load(thumbnailFull).crossFade().into(itemView.articleListImageView)
                        //                                return true
                        //                            }
                        //
                        //                            override fun onException(p0: Exception?, p1: String?, p2: Target<GlideDrawable>?, p3: Boolean): Boolean {
                        //                                throw UnsupportedOperationException()
                        //                            }
                        //
                        //                        })
                        .into(itemView.articleListImageView)
                itemView.articleListNameView.text = title
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}