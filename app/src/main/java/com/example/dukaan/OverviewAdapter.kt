package com.example.dukaan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class OverviewAdapter(var list: List<Overview>) : RecyclerView.Adapter<OverviewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName by lazy {
            itemView.findViewById<TextView>(R.id.tvName)
        }
        val tvValue by lazy {
            itemView.findViewById<TextView>(R.id.tvValue)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemOverview: View =
            inflater.inflate(R.layout.item_overview, parent, false)
        return ViewHolder(itemOverview)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = list[position].name
        holder.tvValue.text = list[position].numbers
    }


}