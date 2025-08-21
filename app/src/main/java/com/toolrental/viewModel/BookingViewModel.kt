package com.toolrental.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.model.Booking

class BookingViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()
    private val _bookings = MutableLiveData<List<Booking>>()
    val bookings: LiveData<List<Booking>> = _bookings

    fun getBookingRequests(ownerId: String) {
        firestore.collection("bookings")
            .whereEqualTo("ownerId", ownerId)
            .whereEqualTo("status", "pending")
            .get()
            .addOnSuccessListener { result ->
                val bookingList = result.toObjects(Booking::class.java)
                _bookings.value = bookingList
            }
    }

    fun updateBookingStatus(bookingId: String, status: String) {
        firestore.collection("bookings")
            .document(bookingId)
            .update("status", status)
    }
}
