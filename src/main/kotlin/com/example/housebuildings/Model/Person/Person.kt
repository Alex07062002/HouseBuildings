package com.example.housebuildings.Model.Person

import com.example.housebuildings.Model.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "person")
data class Person(

    @Column(name = "name_surname", nullable = false)
    @get: NotBlank
    val name : String = "",

    /*@Column(name = "surname", nullable = false) //FIXME Parser name_surname
    @get: NotBlank
    val surname : String = "",*/

    @Column(name = "email", nullable = false)
    @get: NotBlank
    val email : String = "",

    @Column(name = "login", unique = true, nullable = false)
    @get: NotBlank
    val login : String = "",

    @Column(name = "password", nullable = false)
    @get: NotBlank
    val password : String = "", // TODO Encript!!

    @Column(name = "role", nullable = false)
    val role : Role = Role.user
) : BaseEntity<Long>()
