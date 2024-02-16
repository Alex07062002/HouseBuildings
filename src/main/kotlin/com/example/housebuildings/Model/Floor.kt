package com.example.housebuildings.Model

import jakarta.persistence.ManyToOne

data class Floor(
    @ManyToOne
    val house : House,
    val floor : Long
) : BaseEntity<Long>()
