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

class LoginExerciseActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: LoginExerciseMainBinding

    private var mapAccounts = mapOf<String,String>("mandev" to "123","john" to "12345","millie" to "123456","matt" to "456")



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
        Log.w("mapAccounts ==>>", "mapAccounts ==>> ${mapAccounts.containsKey("mandev")}") // Warning log
        Log.w("mapAccounts ==>>", "mapAccounts ==>> ${mapAccounts.get("mandev")}") // Warning log








        // Save username and password when button is clicked
        binding.btnSubmit.setOnClickListener {
            val username = binding.editUsername.text
            val password = binding.editPassword.text
            var attemptCount:Int = 0

//            // Local Authentication process

//            Log.w("getUser val ==>>", "getUser ==>> ${getUser}") // Warning log
//            Log.w("password val ==>>", "getUser ==>> ${password.toString()}") // Warning log

            val getUser = mapAccounts.get(username.toString().trim())


            if (username.toString().isNotEmpty() && password.toString().isNotEmpty()) {
                if (mapAccounts.containsKey(username.toString().trim())) {
                    if (getUser.equals(password.toString())) {
               Log.w("BLACK FIRED ==>>", "BLACK FIRED ==>> ${password.toString()}") // Warning log

                       val snack= Snackbar.make(it,"Hi,$username welcome to Android Kotlin",Snackbar.LENGTH_LONG)
                        snack.show()
                        snack.setAction("Details", {displayToast()})
                    } else {
                        Snackbar.make(it,"Incorrect password",Snackbar.LENGTH_LONG).show()
                    }

                } else {
                    val snack=  Snackbar.make(it,"Invalid Login Attempt",Snackbar.LENGTH_LONG)
                    snack.show()


//                    snack.setAction("Details", {addTextView("Invalid Login ${attemptCount}: ${Calendar.getInstance().time}")})

//                    snack.setAction("Details",{addTextView("Login Succesful: ${Calendar.getInstance().time})

                }

            } else {
                Snackbar.make(it,"All fields are required",Snackbar.LENGTH_LONG).show()
            }



//            if (username.toString() in usernames && password.toString() in passwords) {
//                //Display Toast when user credential matches the stated values
//                //  Toast.makeText(this , "Welcome to Android Kotlin", Toast.LENGTH_SHORT).show()
//                // Display Normal Snackbar
//                //Snackbar.make(it,"Hi, $username welcome to Android Kotlin",Snackbar.LENGTH_LONG).show()
//                //Display snackbar with button
//                val snack = Snackbar.make(it,"Hi, $username welcome to Android Kotlin",Snackbar.LENGTH_LONG)
////                snack.setAction("Details", {displayToast()})
//                // Conditional Rendering of View
//                snack.setAction("Details", {addTextView("Login Succesful: ${Calendar.getInstance().time}")})
//
//                snack.show()
//            } else {
//                //Toast.makeText(this , "Invalid Login Attempt", Toast.LENGTH_SHORT).show()
//                Snackbar.make(it,"Invalid Login Attempt",Snackbar.LENGTH_LONG).show()
//            }
        }

    }

    private fun addTextView(text:String,attemptCount:String) {
        val textView1 = TextView(this)
        textView1.text = text
        textView1.textSize = 16f
        textView1.textAlignment = View.TEXT_ALIGNMENT_CENTER
        binding.myLayout.addView(textView1)
    }

    private fun displayToast() {
        Toast.makeText(this , "Login Successful ${Calendar.getInstance().time}", Toast.LENGTH_SHORT).show()
    }
}