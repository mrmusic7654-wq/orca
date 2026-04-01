package com.app.orca

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ChatAdapter
    private val messages = mutableListOf<Message>()
    private val agent = AgentEngine()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.chatList)
        val input = findViewById<EditText>(R.id.input)
        val send = findViewById<Button>(R.id.sendBtn)

        adapter = ChatAdapter(messages)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        val executor = ActionExecutor(this)

        send.setOnClickListener {
            val text = input.text.toString()
            if (text.isEmpty()) return@setOnClickListener

            messages.add(Message(text, true))

            val action = agent.process(text)
            val response = executor.execute(action)

            messages.add(Message(response, false))

            adapter.notifyDataSetChanged()
            input.text.clear()
        }
    }
}
