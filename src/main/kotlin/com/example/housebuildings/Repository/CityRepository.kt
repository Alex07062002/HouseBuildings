package com.example.housebuildings.Repository

import com.example.housebuildings.Model.City.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CityRepository : JpaRepository<City, Long> { //TODO in 2 iteration filter (maybe)

    @Modifying
    @Query(value = """ SELECT * FROM city WHERE name = (:nameCity)""", nativeQuery = true)
    fun getCityByName(@Param("name") nameCity: String) : City

}