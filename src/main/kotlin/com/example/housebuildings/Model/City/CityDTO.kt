package com.example.housebuildings.Model.City

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class CityDTO(val id : Long?, val name : String)
