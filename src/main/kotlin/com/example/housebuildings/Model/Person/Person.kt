package com.example.housebuildings.Model.Person

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
@Entity
@Table(name = "person")
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @get: NotBlank
    @Column(name = "person_id", nullable = false)
    var id : Long? = null,

    @Column(name = "name_surname", nullable = false)
    @get: NotBlank
    var nameSurname : String = "",

    @Column(name = "email", nullable = false)
    @get: NotBlank
    @Email
    var email : String = "",

    @Column(name = "login", unique = true, nullable = false)
    @get: NotBlank
    var login : String = "",

    @Column(name = "password", nullable = false)
    @get: NotBlank
    var password : String = "", // TODO crypt!!

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    var role : Role = Role.user
)
