package com.example.housebuildings

import com.example.housebuildings.Model.Contract.Contract
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(Contract::class)
class HouseBuildingsApplication

fun main(args: Array<String>) {
    runApplication<HouseBuildingsApplication>(*args)
}
