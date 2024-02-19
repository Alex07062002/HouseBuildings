package com.example.housebuildings.Repository

import com.example.housebuildings.Model.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository : JpaRepository<City, Long> { //TODO in 2 iteration filter (maybe)

}