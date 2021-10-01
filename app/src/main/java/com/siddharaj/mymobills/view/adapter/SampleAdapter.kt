package com.siddharaj.mymobills.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siddharaj.mymobills.R
import com.siddharaj.mymobills.model.SampleModel


/**
 * this is an sample adapter for AllFragment to show all invoices which will ge bring from roomdb
 * currently it gets sample model for displaying invoices in AllFragment
 */
class SampleAdapter(private var items: List<SampleModel>) : RecyclerView.Adapter<SampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sample_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val currentItem = items[position]
        holder.name.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun filterList(filters: ArrayList<SampleModel>){
        items = filters
        notifyDataSetChanged()
    }

}

class SampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.tv_item_name)
}
