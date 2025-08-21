package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_availability.*
import java.text.SimpleDateFormat
import java.util.*

class AvailabilityActivity : AppCompatActivity() {

    private val firestore = FirebaseFirestore.getInstance()
    private val selectedDates = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_availability)

        val toolId = intent.getStringExtra("toolId")!!

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val date = calendar.time
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateString = sdf.format(date)

            if (selectedDates.contains(dateString)) {
                selectedDates.remove(dateString)
            } else {
                selectedDates.add(dateString)
            }
        }

        saveButton.setOnClickListener {
            firestore.collection("tools")
                .document(toolId)
                .update("availability", selectedDates)
                .addOnSuccessListener {
                    // Show confirmation message
                }
        }
    }
}
