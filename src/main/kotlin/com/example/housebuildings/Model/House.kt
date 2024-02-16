package com.example.housebuildings.Model

import jakarta.persistence.ManyToOne

data class House(
    @ManyToOne
    val city : City,

    val address: String,
    val name: String,
    val constructionStartDate : Long,
    val constructionCompletionDate: Long,
    val commissioning: Long?
) : BaseEntity<Long>()
