package com.example.housebuildings.Model.Flat

import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class FlatDTO(val id : Long?,
                   val floorId : Long,
                   val numberOfRooms : Int,
                   val entrance : Int,
                   val cost : Double,
                   val square : Double,
                   val typeOwnerOfFlat : TypeOwnerOfFlat = TypeOwnerOfFlat.free,
                   val typePrice : TypePrice = TypePrice.full)
