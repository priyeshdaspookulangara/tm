package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.model.Tool
import kotlinx.android.synthetic.main.activity_list_tool.*

class ListToolActivity : AppCompatActivity() {

    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_tool)

        listToolButton.setOnClickListener {
            val toolName = toolNameEditText.text.toString()
            val toolDescription = toolDescriptionEditText.text.toString()
            val pricePerDay = pricePerDayEditText.text.toString().toDouble()
            val pricePerWeek = pricePerWeekEditText.text.toString().toDouble()

            val tool = Tool(
                name = toolName,
                description = toolDescription,
                pricePerDay = pricePerDay,
                pricePerWeek = pricePerWeek,
                ownerId = "ownerId" // Replace with actual owner ID
            )

            firestore.collection("tools")
                .add(tool)
                .addOnSuccessListener {
                    // Show confirmation message
                }
        }
    }
}
