package com.toolrental.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toolrental.R
import com.toolrental.model.Earning

class EarningAdapter(private val earnings: List<Earning>) :
    RecyclerView.Adapter<EarningAdapter.EarningViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarningViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_earning, parent, false)
        return EarningViewHolder(view)
    }

    override fun onBindViewHolder(holder: EarningViewHolder, position: Int) {
        val earning = earnings[position]
        holder.bind(earning)
    }

    override fun getItemCount(): Int {
        return earnings.size
    }

    inner class EarningViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val toolName: TextView = itemView.findViewById(R.id.toolName)
        private val amount: TextView = itemView.findViewById(R.id.amount)

        fun bind(earning: Earning) {
            toolName.text = earning.toolName
            amount.text = "₹${earning.amount}"
        }
    }
}
