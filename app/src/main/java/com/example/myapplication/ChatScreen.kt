package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityChatScreenBinding
import com.example.myapplication.databinding.FragmentMainBinding

class ChatScreen : AppCompatActivity() {

    lateinit var binding: ActivityChatScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginCheck()


        binding.apply {

            if (savedInstanceState == null){
                openFragment(Main())
            }

            bottomNavigationView.setOnItemSelectedListener { button ->
                when(button.itemId){
                    R.id.home -> openFragment(Main())
                    R.id.profile -> openFragment(ProfileFragment())
                }
                false
            }
        }

    }

    fun openFragment(fragment: Fragment): Boolean{
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        return true
    }

    fun loginCheck(){
        val sharedPref = getSharedPreferences("app", MODE_PRIVATE)
        if (sharedPref.getBoolean("isLogin", false) == false){
            val intent = Intent(this@ChatScreen, MainActivity::class.java)
            startActivity(intent)
        }
    }
}