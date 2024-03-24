package com.example.housebuildings.Model.House

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class HouseDTO(val id : Long?, val cityId : Long,
                    val address: String,
                    val name: String,
                    val constructionStartDate : Long,
                    val constructionCompletionDate: Long,
                    val commissioning: Long?)
