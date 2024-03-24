package com.example.housebuildings.Model.Contract

import com.example.housebuildings.Model.Flat.TypeOwnerOfFlat
import com.example.housebuildings.Model.Flat.TypePrice
import kotlinx.serialization.Serializable
import lombok.Data

@Data
@Serializable
data class ContractDTO(val id : Long?,
                       val flatId : Long,
                       val personId : Long,
                       val flatFloorHouseCityName : String,
                       val flatFloorHouseAddress : String,
                       val flatFloorHouseName : String,
                       val flatFloorHouseConstructionstartdate : Long,
                       val flatFloorHouseConstructioncompletiondate : Long,
                       val flatFloorHouseCommissioning : Long?,
                       val flatFloorFloor : Long,
                       val flatNumberOfRooms : Int,
                       val flatEntrance : Int,
                       val flatCost : Double,
                       val flatSquare : Double,
                       val flatTypeOwnerOfFlat : TypeOwnerOfFlat,
                       val flatTypePrice : TypePrice,
                       val typeOfPay : TypeOfPay,
                       val status : StatusOfContract)
