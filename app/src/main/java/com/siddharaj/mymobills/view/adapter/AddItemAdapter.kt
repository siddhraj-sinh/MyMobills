package com.siddharaj.mymobills.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siddharaj.mymobills.R
import com.siddharaj.mymobills.model.entities.Items

class AddItemAdapter(private val items:ArrayList<Items>):RecyclerView.Adapter<AddItemViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddItemViewModel {
        return AddItemViewModel(View.inflate(parent.context, R.layout.add_item_layout,null))
    }

    override fun onBindViewHolder(holder: AddItemViewModel, position: Int) {
       val currentItem = items[position]
        val currentItemQuantity = currentItem.quantity
        val currentItemUnitCost = currentItem.unitCost
        val currentItemSubTotal = currentItemQuantity.toInt() * currentItemUnitCost.toInt()
        holder.itemName.text = currentItem.itemDescription
        holder.itemQuantity.text = "$currentItemQuantity x $currentItemUnitCost"
        holder.itemSubTotal.text = currentItemSubTotal.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class AddItemViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val itemName: TextView = itemView.findViewById(R.id.tv_item_description)
    val itemQuantity:TextView = itemView.findViewById(R.id.tv_item_quantity)
    val itemSubTotal:TextView =itemView.findViewById(R.id.tv_item_subtotal)
}
