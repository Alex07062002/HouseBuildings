package com.example.housebuildings

import com.example.housebuildings.Model.City
import com.example.housebuildings.Model.Contract.Contract
import com.example.housebuildings.Model.Flat.Flat
import com.example.housebuildings.Model.Floor
import com.example.housebuildings.Model.House
import com.example.housebuildings.Model.Person.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class HouseBuildingsApplication

fun main(args: Array<String>) {
    runApplication<HouseBuildingsApplication>(*args)
}
