package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    lateinit var binding: ActivityChatBinding

    object Chat{
        var message = Message(
            id = null,
            text = null,
            to = null,
            from = null
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            sendMessage()
        }

    }

    fun sendMessage() {
        binding.apply {
            send.setOnClickListener {
                Chat.message = Message(getTimeInMillis(), editText.text.toString(), "", "")
                Toast.makeText(this@ChatActivity, "Сообщение принято", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getTimeInMillis(): Long {
        val currentTime = System.currentTimeMillis()
        return currentTime
    }
}