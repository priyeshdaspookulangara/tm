package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.toolrental.adapter.BookingAdapter
import com.toolrental.model.Booking
import com.toolrental.viewModel.BookingViewModel
import kotlinx.android.synthetic.main.activity_rental_requests.*

class RentalRequestsActivity : AppCompatActivity() {

    private lateinit var viewModel: BookingViewModel
    private lateinit var bookingAdapter: BookingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rental_requests)

        viewModel = ViewModelProvider(this).get(BookingViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.bookings.observe(this, Observer { bookings ->
            bookingAdapter = BookingAdapter(bookings,
                { booking -> viewModel.updateBookingStatus(booking.id, "accepted") },
                { booking -> viewModel.updateBookingStatus(booking.id, "declined") }
            )
            recyclerView.adapter = bookingAdapter
        })

        viewModel.getBookingRequests("ownerId") // Replace with actual owner ID
    }
}
