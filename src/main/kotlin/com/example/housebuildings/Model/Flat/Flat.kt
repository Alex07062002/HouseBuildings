package com.example.housebuildings.Model.Flat

import com.example.housebuildings.Model.BaseEntity
import com.example.housebuildings.Model.Floor
import jakarta.persistence.ManyToOne

data class Flat(
    @ManyToOne
    val floor : Floor,

    val numberOfRooms : Int,
    val entrance : Int,
    val cost : Double,
    val square : Double,
    val typeOwnerOfFlat : TypeOwnerOfFlat,
    val typePrice : TypePrice

) : BaseEntity<Long>()
