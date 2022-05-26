package com.example.harajtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter (var contex: Context, var data: ArrayList<PostItem>, val listener: OnItemClickListener): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        var photoView: ImageView = view.findViewById(R.id.imageView_thumb_url)
        var userName: TextView =  view.findViewById(R.id.textView_userName)
        var city: TextView =  view.findViewById(R.id.textView_city)
        var title: TextView =  view.findViewById(R.id.textView_title)
        var date : TextView = view.findViewById(R.id.date_textView)
    }

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var postItem : PostItem = data[position]
        holder.title.text = postItem.title
        holder.userName.text = postItem.username
        holder.city.text = postItem.city
        holder.date.text = postItem.date.toString()

        Glide.with(contex).load(postItem.thumbURL)
            .into(holder.photoView)


        /**Setting click listener to the item in the recyclerview*/
        holder.itemView.setOnClickListener {
            listener.OnItemClick(postItem)
        }
    }

    /**This function returns the size of the elements in the recylcer view*/
    override fun getItemCount(): Int {
        return data.size
    }

    fun addPost(listOfPost : ArrayList<PostItem>){
        data.addAll(listOfPost)
        notifyDataSetChanged()
    }

    /**The interface class for the on click listener, the function(s) inside
     * should be overridden in the class implementing this class*/
    interface OnItemClickListener {
        fun OnItemClick(postItem: PostItem)
    }
}