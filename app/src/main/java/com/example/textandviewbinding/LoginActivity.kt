package com.example.textandviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.textandviewbinding.databinding.LoginMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class LoginActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: LoginMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate the activity binding
        binding = LoginMainBinding.inflate(layoutInflater )
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
                //  Toast.makeText(this , "Welcome to Android Kotlin", Toast.LENGTH_SHORT).show()
                // Display Normal Snackbar
                //Snackbar.make(it,"Hi, $username welcome to Android Kotlin",Snackbar.LENGTH_LONG).show()
                //Display snackbar with button
                val snack = Snackbar.make(it,"Hi, $username welcome to Android Kotlin",Snackbar.LENGTH_LONG)
                snack.setAction("Details", {displayToast()})
                snack.show()
            } else {
                //Toast.makeText(this , "Invalid Login Attempt", Toast.LENGTH_SHORT).show()
                Snackbar.make(it,"Login Succesful",Snackbar.LENGTH_LONG).show()
            }
        }

    }

    private fun displayToast() {
        Toast.makeText(this , "Invalid Login Attempt ${Calendar.getInstance().time}", Toast.LENGTH_SHORT).show()
    }
}