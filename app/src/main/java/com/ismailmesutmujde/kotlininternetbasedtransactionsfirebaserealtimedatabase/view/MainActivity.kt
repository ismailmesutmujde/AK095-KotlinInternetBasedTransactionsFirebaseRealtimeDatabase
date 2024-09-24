package com.ismailmesutmujde.kotlininternetbasedtransactionsfirebaserealtimedatabase.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.ismailmesutmujde.kotlininternetbasedtransactionsfirebaserealtimedatabase.R
import com.ismailmesutmujde.kotlininternetbasedtransactionsfirebaserealtimedatabase.datamodel.Persons


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()
        val refPersons = database.getReference("persons")

        // firebase insert person
        //val person = Persons("Sedat", 10)
        //refPersons.push().setValue(person)

        // firebase delete person
        //refPersons.child("-O7ZK_v3-IdSrxccWVIX").removeValue()

        // firebase update person
        val updateInfo = HashMap<String,Any>()
        updateInfo["person_name"] = "Gamze"
        updateInfo["person_age"] = 29
        refPersons.child("-O7ZKNmJHAisincZbAso").updateChildren(updateInfo)

    }
}