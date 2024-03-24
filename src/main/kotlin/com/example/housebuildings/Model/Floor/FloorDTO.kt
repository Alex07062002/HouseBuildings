package com.example.housebuildings.Model.Floor

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class FloorDTO(val id : Long?, val houseId : Long, val floor : Long)