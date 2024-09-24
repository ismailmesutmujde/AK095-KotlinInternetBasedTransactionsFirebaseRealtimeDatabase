package com.ismailmesutmujde.kotlininternetbasedtransactionsfirebaserealtimedatabase.datamodel

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Persons(var person_name:String? = "",
                   var person_age:Int? = 0) {

}