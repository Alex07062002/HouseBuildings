package com.example.housebuildings.Model.Person

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class PersonUpdateDTO(val name : String,
                           val surname : String,
                           val email : String)
