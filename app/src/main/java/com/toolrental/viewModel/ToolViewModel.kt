package com.toolrental.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.model.Tool

class ToolViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()
    private val _tools = MutableLiveData<List<Tool>>()
    val tools: LiveData<List<Tool>> = _tools

    fun searchTools(query: String) {
        firestore.collection("tools")
            .whereEqualTo("name", query)
            .get()
            .addOnSuccessListener { result ->
                val toolList = result.toObjects(Tool::class.java)
                _tools.value = toolList
            }
    }
}
