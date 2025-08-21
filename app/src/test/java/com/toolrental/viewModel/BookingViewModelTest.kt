package com.toolrental.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BookingViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BookingViewModel

    @Before
    fun setup() {
        viewModel = BookingViewModel()
    }

    @Test
    fun getBookingRequests_returnsNoBookings_ifNoBookingsMatchQuery() {
        viewModel.getBookingRequests("non-existent-owner")
        val bookings = viewModel.bookings.value
        assertEquals(0, bookings?.size)
    }
}
