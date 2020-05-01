package com.lucas.studio.assign

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addcontact.setOnClickListener{
            intent = Intent(this, Contacts::class.java)
            startActivity(intent)
        }
        viewcontact.setOnClickListener{
            intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
        }
logout.setOnClickListener{
    FirebaseAuth.getInstance().signOut()
    intent = Intent(this, Splash::class.java)
    startActivity(intent)
    finish()
}
    }
}



