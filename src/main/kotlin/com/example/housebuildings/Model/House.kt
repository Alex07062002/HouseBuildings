package com.example.housebuildings.Model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank


@Entity
@Table(name = "house")
data class House(
    @ManyToOne(cascade = [CascadeType.ALL])
    @get: NotBlank
    @JoinColumn(name = "city_id", nullable = false)
    val city : City? = null,
    @get: NotBlank
    @Column(name = "address", nullable = false)
    val address: String = "",
    @get: NotBlank
    @Column(name = "name", nullable = false)
    val name: String = "",
    @get: NotBlank
    @Column (name = "constructionStartDate", nullable = false)
    val constructionStartDate : Long? = null, //FIXME change in db (timestamp to bigint)
    @get: NotBlank
    @Column( name = "constructionCompletionDate", nullable = false)
    val constructionCompletionDate: Long? = null, //FIXME change in db (timestamp to bigint)
    @Column( name = "commissioning")
    val commissioning: Long? = null //FIXME change in db (timestamp to bigint)
) : BaseEntity<Long>()
