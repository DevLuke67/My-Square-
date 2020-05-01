package com.lucas.studio.assign

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_contacts.*

class Contacts : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        contactsave.setOnClickListener {
            var name = contactname.text.toString()
            var phone1 = contactphone1.text.toString()
            var phone2 = contactphone2.text.toString()
            var description = contactdescription.text.toString()
            var time = System.currentTimeMillis()

            var progress = ProgressDialog(this)
            progress.setTitle("syncing")
            progress.setMessage("please wait...")

            if (name.isEmpty() or phone1.isEmpty() or phone2.isEmpty() or description.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_LONG).show()
            } else {

                var contact = FirebaseDatabase.getInstance().reference.child("contacts/$time")
                progress.show()
                var data = Contact(name, phone1, phone2, description)
                contact.setValue(data).addOnCompleteListener { task ->
                    progress.dismiss()
                    if (task.isSuccessful) {

                        Toast.makeText(this, "saved successfully", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "An Error ocurred!", Toast.LENGTH_LONG).show()
                    }

                    }
                }
            }
        }
    }
