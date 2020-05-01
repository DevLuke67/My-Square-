package com.lucas.studio.assign

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnLogin.setOnClickListener{
            var name = TxtName.text.toString()
            var email = TxtEmail.text.toString()
            var password = TxtPassword.text.toString()
            var confirmpassword = TxtConfirm.text.toString()

            var progress = ProgressDialog(this)
            progress.setTitle("saving details")
            progress.setMessage("please wait...")

            if (name.isEmpty() or email.isEmpty() or password.isEmpty() or confirmpassword.isEmpty()){
                Toast.makeText(this,"please fill in the fields",Toast.LENGTH_SHORT).show()
            }else{
                if (password != confirmpassword){
                    Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
                }else{
                    progress.show()
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task->
                        progress.dismiss()
                        if (task.isSuccessful){
                            startActivity(Intent(this, MainActivity::class.java))
                            Toast.makeText(this,"Registration successful",Toast.LENGTH_SHORT).show()
                            finish()
                        }else{
                            Toast.makeText(this, "Error connection / Details matches an existing user or invalid",Toast.LENGTH_LONG).show()
                        }
                    })
                }
            }
        }

        }
    }
