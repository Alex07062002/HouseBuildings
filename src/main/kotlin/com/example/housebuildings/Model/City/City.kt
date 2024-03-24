package com.example.housebuildings.Model.City

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
@Entity
@Table(name = "city")
class City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @get: NotBlank
    @Column(name = "city_id", nullable = false)
    var id : Long? = null,
    @get: NotBlank
    @Column(name = "name", nullable = false)
    var name: String = ""
)

