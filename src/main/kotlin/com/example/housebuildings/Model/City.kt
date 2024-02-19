package com.example.housebuildings.Model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "city")
class City(
    @get: NotBlank
    @Column(name = "name", nullable = false)
    var name: String = ""
) : BaseEntity<Long>()

