package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.model.ToolCondition
import kotlinx.android.synthetic.main.activity_tool_condition.*

class ToolConditionActivity : AppCompatActivity() {

    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_condition)

        val toolId = intent.getStringExtra("toolId")!!

        addPhotoButton.setOnClickListener {
            // Placeholder for adding photos
            Toast.makeText(this, "Add Photo Clicked", Toast.LENGTH_SHORT).show()
        }

        saveButton.setOnClickListener {
            val notes = notesEditText.text.toString()
            val toolCondition = ToolCondition(
                toolId = toolId,
                notes = notes,
                // photos = ...
            )
            firestore.collection("toolConditions")
                .add(toolCondition)
                .addOnSuccessListener {
                    // Show confirmation message
                }
        }
    }
}
