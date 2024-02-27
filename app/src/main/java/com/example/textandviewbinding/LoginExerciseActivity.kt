package com.example.textandviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.textandviewbinding.databinding.LoginExerciseMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Arrays
import java.util.Calendar
import kotlin.system.exitProcess

class LoginExerciseActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: LoginExerciseMainBinding

    private var mapAccounts = mapOf<String,String>("mandev" to "123","john" to "12345","millie" to "123456","matt" to "456")
    var attemptCount:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate the activity binding
        binding = LoginExerciseMainBinding.inflate(layoutInflater )
        val view = binding.root
        setContentView(view)
        // setContentView(R.layout.activity_main)
        //Log.w("Account==>>", "Accounts ==>> ${usernames.size}") // Warning log
        //Log.w("Usernames ==>>", "Accounts ==>> ${"mandev" in usernames}") // Warning log
        //Log.w("Passwords==>>", "Accounts ==>> ${"123" in passwords}") // Warning log
//        Log.w("mapAccounts ==>>", "mapAccounts ==>> ${mapAccounts.containsKey("mandev")}") // Warning log
//        Log.w("mapAccounts ==>>", "mapAccounts ==>> ${mapAccounts.get("mandev")}") // Warning log



        // Save username and password when button is clicked
        binding.btnSubmit.setOnClickListener {
            val username = binding.editUsername.text
            val password = binding.editPassword.text


            if (attemptCount.toInt()  === 3) {
                Toast.makeText(this , "You have reached a maximum of $attemptCount invalid Login Attempts", Toast.LENGTH_SHORT).show()
                exitProcess(-1)
            }

//            // Local Authentication process

            val getUser = mapAccounts.get(username.toString().trim())

            if (username.toString().isNotEmpty() && password.toString().isNotEmpty()) {
                if (mapAccounts.containsKey(username.toString().trim())) {
                    if (getUser.equals(password.toString())) {
                       val snack= Snackbar.make(it,"Hi,$username welcome to Android Kotlin",Snackbar.LENGTH_LONG)
                        snack.show()
                        snack.setAction("Details", {displayToast()})
                    } else {
                        Snackbar.make(it,"Incorrect password",Snackbar.LENGTH_LONG).show()
                    }
                } else {
                    val snack=  Snackbar.make(it,"Invalid Login Attempt",Snackbar.LENGTH_LONG)
                    snack.show()
                     attemptCount++
                    snack.setAction("Details",{addTextView(attemptCount.toString())})
                }

            } else {
                Snackbar.make(it,"All fields are required",Snackbar.LENGTH_LONG).show()
            }

        }

    }

    private fun addTextView(attemptCount:String) {

        val textView1 = TextView(this)
        val printText = "Invalid Login #$attemptCount: ${Calendar.getInstance().time}"
        textView1.text = printText
        textView1.textSize = 16f
        textView1.textAlignment = View.TEXT_ALIGNMENT_CENTER
        binding.myLayout.addView(textView1)
    }

    private fun displayToast() {
        Toast.makeText(this , "Login Successful ${Calendar.getInstance().time}", Toast.LENGTH_SHORT).show()
    }
}