package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Flat.Flat
import com.example.housebuildings.Model.House
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface FlatRepository : JpaRepository<Flat, Long> {

    @Modifying
    @Query(value = """ SELECT * FROM flat WHERE floor_id = (:floorId)""", nativeQuery = true)
    fun getAllFlatByFloorId(@Param("floorId") floorId: Long) : List<Flat>
}