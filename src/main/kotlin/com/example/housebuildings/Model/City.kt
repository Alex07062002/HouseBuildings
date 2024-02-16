package com.example.housebuildings.Model

import jakarta.persistence.*


data class City(val name: String) : BaseEntity<Long>()
