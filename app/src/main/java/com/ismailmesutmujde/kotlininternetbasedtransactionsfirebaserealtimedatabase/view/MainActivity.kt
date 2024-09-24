package com.ismailmesutmujde.kotlininternetbasedtransactionsfirebaserealtimedatabase.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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
        /*
        val updateInfo = HashMap<String,Any>()
        updateInfo["person_name"] = "Gamze"
        updateInfo["person_age"] = 29
        refPersons.child("-O7ZKNmJHAisincZbAso").updateChildren(updateInfo)*/

        // firebase data reading
        refPersons.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (p in snapshot.children) {
                    val person = p.getValue(Persons::class.java)
                    if(person != null) {
                        val key = p.key
                        Log.e("****************************","****************************")
                        Log.e("Person key", key!!)
                        Log.e("Person name", person.person_name!!)
                        Log.e("Person age", (person.person_age!!).toString())

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }
}