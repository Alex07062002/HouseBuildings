package com.example.housebuildings.Model.Contract

import com.example.housebuildings.Model.BaseEntity
import com.example.housebuildings.Model.Flat.Flat
import com.example.housebuildings.Model.Person.Person
import jakarta.persistence.*


data class Contract (
    val flat : Flat,
    val person : Person,
    val typeOfPay : TypeOfPay,
    val statusOfContract : StatusOfContract

    ) : BaseEntity<Long>()
