package com.example.news24.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news24.R
import com.example.news24.R.layout.news_item

class NewsAdapter(private var dataSet: List<News>, var listener:((Int) -> Unit)? = null) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.news_name)
            imageView = view.findViewById(R.id.news_img)
        }
    }
    fun updateList(list: List<com.example.news24.presentation.list.News>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(news_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val news : News = dataSet[position]
        viewHolder.textView.text = news.name
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(position)
        }

        Glide
            .with(viewHolder.itemView.context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/pokemon/${position + 1}.png" )
            .centerCrop()
            .into(viewHolder.imageView);
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
