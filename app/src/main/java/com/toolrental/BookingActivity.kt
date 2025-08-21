package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.model.Booking
import com.toolrental.model.Tool
import kotlinx.android.synthetic.main.activity_booking.*
import java.util.*

class BookingActivity : AppCompatActivity() {

    private lateinit var tool: Tool
    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        tool = intent.getParcelableExtra("tool")!!

        requestButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = calendarView.date
            val selectedDate = calendar.time

            val booking = Booking(
                toolId = tool.id,
                renterId = "renterId", // Replace with actual renter ID
                ownerId = tool.ownerId,
                bookingDate = selectedDate,
                status = "pending"
            )

            firestore.collection("bookings")
                .add(booking)
                .addOnSuccessListener {
                    // Show confirmation message
                }
        }
    }
}
