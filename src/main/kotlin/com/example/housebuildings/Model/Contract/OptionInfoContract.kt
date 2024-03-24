package com.example.housebuildings.Model.Contract

import kotlinx.serialization.Serializable

@Serializable
data class OptionInfoContract(val phone : String, val typeOfPay: TypeOfPay)
