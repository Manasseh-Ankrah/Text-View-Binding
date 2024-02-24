package com.example.textandviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.textandviewbinding.databinding.ActivityMainBinding

class TextInputLayoutActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate the activity binding
        binding = ActivityMainBinding.inflate(layoutInflater )
        val view = binding.root
        setContentView(view)
        // setContentView(R.layout.activity_main)

        // Save username and password when button is clicked
        binding.btnSubmit.setOnClickListener {
            val username = binding.editUsername.text
            val password = binding.editPassword.text

            // Local Authentication process
            if (username.toString().equals("mandev",true) && password.toString().equals("123")) {
                //Display Toast when user credential matches the stated values
                Toast.makeText(this , "Welcome to Android Kotlin", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this , "Invalid Login Attempt", Toast.LENGTH_SHORT).show()
            }
        }

    }
}