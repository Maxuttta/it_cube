package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val LOGIN = "admin"
    val PASSWORD = "1234"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            loginButton.setOnClickListener {
                if (login.text.toString() == LOGIN && password.text.toString() == PASSWORD){
                    Log.d("password", "${login.text.toString()} || ${password.text.toString()}")

                    val sharedPref = getSharedPreferences("app", MODE_PRIVATE).edit()
                    sharedPref.putBoolean("isLogin", true).apply()

                    val intent = Intent(this@MainActivity, ChatScreen::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}