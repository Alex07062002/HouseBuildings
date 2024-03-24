package com.example.housebuildings.Model.Person

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class PersonDTO(val id : Long?,
                     val name : String,
                     val surname : String,
                     val email : String,
                     val login : String,
                     val password : String, // TODO Encrypt!!
                     val role : Role = Role.user)
