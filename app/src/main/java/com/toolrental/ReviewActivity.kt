package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.model.Review
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {

    private val firestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val toolId = intent.getStringExtra("toolId")!!
        val ownerId = intent.getStringExtra("ownerId")!!

        submitButton.setOnClickListener {
            val rating = ratingBar.rating
            val reviewText = reviewEditText.text.toString()

            val review = Review(
                toolId = toolId,
                ownerId = ownerId,
                renterId = "renterId", // Replace with actual renter ID
                rating = rating,
                text = reviewText
            )

            firestore.collection("reviews")
                .add(review)
                .addOnSuccessListener {
                    // Show confirmation message
                }
        }
    }
}
