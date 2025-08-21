package com.toolrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.adapter.MessageAdapter
import com.toolrental.model.Message
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatAimport androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.toolrental.adapter.MessageAdapter
import com.toolrental.model.Message
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    private val firestore = FirebaseFirestore.getInstance()
    private lateinit var messageAdapter: MessageAdapter
    private val messages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView.layoutManager = LinearLayoutManager(this)
        messageAdapter = MessageAdapter(messages)
        recyclerView.adapter = messageAdapter

        val bookingId = intent.getStringExtra("bookingId")!!

        firestore.collection("chats")
            .document(bookingId)
            .collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    return@addSnapshotListener
                }

                messages.clear()
                for (doc in snapshot!!) {
                    messages.add(doc.toObject(Message::class.java))
                }
                messageAdapter.notifyDataSetChanged()
            }

        sendButton.setOnClickListener {
            val message = Message(
                senderId = "senderId", // Replace with actual sender ID
                text = messageEditText.text.toString()
            )

            firestore.collection("chats")
                .document(bookingId)
                .collection("messages")
                .add(message)

            messageEditText.text.clear()
        }
    }
}ctivity() {

    private val firestore = FirebaseFirestore.getInstance()
    private lateinit var messageAdapter: MessageAdapter
    private val messages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView.layoutManager = LinearLayoutManager(this)
        messageAdapter = MessageAdapter(messages)
        recyclerView.adapter = messageAdapter

        val bookingId = intent.getStringExtra("bookingId")!!

        firestore.collection("chats")
            .document(bookingId)
            .collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    return@addSnapshotListener
                }

                messages.clear()
                for (doc in snapshot!!) {
                    messages.add(doc.toObject(Message::class.java))
                }
                messageAdapter.notifyDataSetChanged()
            }

        sendButton.setOnClickListener {
            val message = Message(
                senderId = "senderId", // Replace with actual sender ID
                text = messageEditText.text.toString()
            )

            firestore.collection("chats")
                .document(bookingId)
                .collection("messages")
                .add(message)

            messageEditText.text.clear()
        }
    }
}
