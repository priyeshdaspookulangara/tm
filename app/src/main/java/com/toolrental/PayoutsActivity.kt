package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.toolrental.adapter.EarningAdapter
import com.toolrental.model.Earning
import kotlinx.android.synthetic.main.activity_payouts.*

class PayoutsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payouts)

        linkAccountButton.setOnClickListener {
            // Placeholder for linking bank account
            Toast.makeText(this, "Link Bank Account Clicked", Toast.LENGTH_SHORT).show()
        }

        earningHistoryRecyclerView.layoutManager = LinearLayoutManager(this)
        val earnings = listOf(
            Earning("Tool A", 100.0),
            Earning("Tool B", 150.0),
            Earning("Tool C", 200.0)
        )
        val earningAdapter = EarningAdapter(earnings)
        earningHistoryRecyclerView.adapter = earningAdapter
    }
}
