package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.toolrental.model.Tool
import kotlinx.android.synthetic.main.activity_tool_detail.*

class ToolDetailActivity : AppCompatActivity() {

    private lateinit var tool: Tool

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_detail)

        tool = intent.getParcelableExtra("tool")!!

        toolName.text = tool.name
        toolDescription.text = tool.description
        rentalRates.text = "₹${tool.pricePerDay}/day, ₹${tool.pricePerWeek}/week"

        Glide.with(this)
            .load(tool.images.firstOrNull())
            .into(toolImage)

        rentButton.setOnClickListener {
            // Initiate booking process
        }
    }
}
