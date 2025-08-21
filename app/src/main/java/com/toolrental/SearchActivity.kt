package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.toolrental.adapter.ToolAdapter
import com.toolrental.viewModel.ToolViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: ToolViewModel
    private lateinit var toolAdapter: ToolAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel = ViewModelProvider(this).get(ToolViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.tools.observe(this, Observer { tools ->
            toolAdapter = ToolAdapter(tools)
            recyclerView.adapter = toolAdapter
        })

        viewModel.searchTools("Hammer") // Example search query
    }
}
