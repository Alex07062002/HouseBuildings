package com.example.housebuildings.Repository

import com.example.housebuildings.Model.House
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface HouseRepository : JpaRepository<House, Long> {

    @Modifying
    @Query(value = """ SELECT * FROM house WHERE city_id = (:cityId)""", nativeQuery = true)
    fun getAllHouseByCityId(@Param("cityId") cityId: Long) : List<House>

}