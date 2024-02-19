package com.example.housebuildings.Service

import com.example.housebuildings.Model.City
import com.example.housebuildings.Repository.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
class CityService {

    @Autowired
    private lateinit var  cityRepository : CityRepository

    fun getAllCity() : List<City> = cityRepository.findAll()
}