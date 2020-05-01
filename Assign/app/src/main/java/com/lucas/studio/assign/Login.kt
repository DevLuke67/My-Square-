package com.lucas.studio.assign

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_splash.*

class Login : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        register.setOnClickListener{
            intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        login.setOnClickListener{
            var LoginEmail = LoginEmail.text.toString()
            var LoginPassword = LoginPassword.text.toString()

            var progress = ProgressDialog(this)
            progress.setTitle("Loging in")
            progress.setMessage("please wait...")

            if (LoginEmail.isEmpty() or LoginPassword.isEmpty()){
                Toast.makeText(this,"Please fill in the fields",Toast.LENGTH_LONG).show()
            }else{
                progress.show()
                mAuth.signInWithEmailAndPassword(LoginEmail, LoginPassword).addOnCompleteListener(this, OnCompleteListener { task ->
                    progress.dismiss()
                    if (task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                        Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(this,"Incorrect Email or Password",Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }
}
