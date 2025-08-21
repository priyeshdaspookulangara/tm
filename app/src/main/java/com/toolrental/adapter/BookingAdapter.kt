package com.toolrental.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toolrental.R
import com.toolrental.model.Booking

class BookingAdapter(
    private val bookings: List<Booking>,
    private val onAccept: (Booking) -> Unit,
    private val onDecline: (Booking) -> Unit
) :
    RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_booking, parent, false)
        return BookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val booking = bookings[position]
        holder.bind(booking)
    }

    override fun getItemCount(): Int {
        return bookings.size
    }

    inner class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val renterName: TextView = itemView.findViewById(R.id.renterName)
        private val bookingDate: TextView = itemView.findViewById(R.id.bookingDate)
        private val acceptButton: Button = itemView.findViewById(R.id.acceptButton)
        private val declineButton: Button = itemView.findViewById(R.id.declineButton)

        fun bind(booking: Booking) {
            renterName.text = "Renter: ${booking.renterId}" // Replace with actual renter name
            bookingDate.text = "Date: ${booking.bookingDate}"
            acceptButton.setOnClickListener { onAccept(booking) }
            declineButton.setOnClickListener { onDecline(booking) }
        }
    }
}
