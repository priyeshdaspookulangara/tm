package com.toolrental.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toolrental.R
import com.toolrental.model.Tool

class ToolAdapter(private val tools: List<Tool>) :
    RecyclerView.Adapter<ToolAdapter.ToolViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tool, parent, false)
        return ToolViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToolViewHolder, position: Int) {
        val tool = tools[position]
        holder.bind(tool)
    }

    override fun getItemCount(): Int {
        return tools.size
    }

    inner class ToolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val toolName: TextView = itemView.findViewById(R.id.toolName)
        private val toolPrice: TextView = itemView.findViewById(R.id.toolPrice)
        private val toolImage: ImageView = itemView.findViewById(R.id.toolImage)

        fun bind(tool: Tool) {
            toolName.text = tool.name
            toolPrice.text = "₹${tool.pricePerDay}/day"
            Glide.with(itemView.context)
                .load(tool.images.firstOrNull())
                .into(toolImage)
        }
    }
}
