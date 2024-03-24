package com.example.housebuildings

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HouseBuildingsApplication

/**
 * check swagger config
 * http://127.0.0.1:8080/swagger-ui/index.html
 */

fun main(args: Array<String>) {
    runApplication<HouseBuildingsApplication>(*args)
}
