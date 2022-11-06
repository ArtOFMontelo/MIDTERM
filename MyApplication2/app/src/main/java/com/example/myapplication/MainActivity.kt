package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.myapplication.EmailValidator.Companion.isEmailValid
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = findViewById<TextView>(R.id.nameText)
        val lastName = findViewById<TextView>(R.id.lastNameText)
        val email = findViewById<TextView>(R.id.emailText)
        val password = findViewById<TextView>(R.id.passwordText)
        val check = findViewById<CheckBox>(R.id.checkBox)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val myToast=Toast.makeText(applicationContext,"You registered succesfully",Toast.LENGTH_SHORT).show()
        val ToastDec=Toast.makeText(applicationContext,"Name should be at least 3 letters, lastname at least 5 , password should contain at least 1 number",Toast.LENGTH_SHORT).show()


        submitButton.setOnClickListener{
            if (name.length() > 3 && lastName.length()>5){
               isEmailValid(email.toString())
              isValidPassword(password.toString())
                check.isChecked
                myToast
            }else{
                ToastDec
            }

        }



    }
}
class EmailValidator{
    companion object {
        @JvmStatic
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";
        fun isEmailValid(email: String): Boolean {
            return EMAIL_REGEX.toRegex().matches(email);
        }
    }
}
fun isValidPassword(password: String): Boolean {
    if (password.length < 8 && password.filter { !it.isLetterOrDigit() }.firstOrNull()==null) return true
    return true
}