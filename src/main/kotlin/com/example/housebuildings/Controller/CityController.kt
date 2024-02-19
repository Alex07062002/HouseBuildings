package com.example.housebuildings.Controller

import com.example.housebuildings.Model.City
import com.example.housebuildings.Service.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/city")
class CityController {

    @Autowired
    private lateinit var cityService : CityService

    @GetMapping()
    fun getAllCity() : List<City> = cityService.getAllCity()

}