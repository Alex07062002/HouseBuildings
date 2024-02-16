package com.example.housebuildings.Model.Person

import com.example.housebuildings.Model.BaseEntity

data class Person(
    val name : String,
    val surname : String,
    val email : String,
    val login : String,
    val password : String, // TODO Encript!!
    val role : Role
) : BaseEntity<Long>()
