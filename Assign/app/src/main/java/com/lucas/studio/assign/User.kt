package com.lucas.studio.assign

import android.provider.ContactsContract

class User{
    var name:String = ""
    var email:String = ""
    var password:String = ""
    var confirmPass:String =""

    constructor(name: String, email:String, password:String, confirmPass:String){
        this.name = name
        this.email = email
        this.password = password
        this.confirmPass = confirmPass
    }
    constructor()
}
