package com.example.dukaan

import android.graphics.Outline
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var list: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private val viewOutlineProvider: ViewOutlineProvider = @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height, 12f)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemName by lazy {
            itemView.findViewById<TextView>(R.id.tvItemName)
        }
        val tvItemPrice by lazy {
            itemView.findViewById<TextView>(R.id.tvItemPrice)
        }
        val tvOrderId by lazy {
            itemView.findViewById<TextView>(R.id.tvOrderId)
        }
        val ivProduct by lazy {
            itemView.findViewById<ImageView>(R.id.ivProduct)
        }
        val tvTime by lazy {
            itemView.findViewById<TextView>(R.id.tvTime)
        }
        val tvPaymentType by lazy {
            itemView.findViewById<TextView>(R.id.tvPaymentType)
        }
        val labelCard by lazy {
            itemView.findViewById<CardView>(R.id.labelCard)
        }
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemProduct: View =
            inflater.inflate(R.layout.item_product, parent, false)
        val viewHolder = ViewHolder(itemProduct)
        viewHolder.labelCard.clipToOutline = true
        viewHolder.labelCard.outlineProvider = viewOutlineProvider
        viewHolder.itemView.clipToOutline = true
        viewHolder.itemView.outlineProvider = viewOutlineProvider
        return ViewHolder(itemProduct)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItemPrice.text = "₹${list[position].price}"
        holder.tvOrderId.text = list[position].orderId
        holder.tvItemName.text = list[position].itemName
        holder.ivProduct.setImageResource(list[position].productImgResId)
        holder.tvTime.text = list[position].timeData
        with(list[position].paymentType) {
            holder.tvPaymentType.text = type
            with(ContextCompat.getColor(holder.itemView.context,paymentColor)){
                holder.labelCard.setBackgroundColor(this)
                holder.tvPaymentType.setTextColor(this)
            }
        }
    }
}