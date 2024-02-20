package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Floor
import com.example.housebuildings.Model.House
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface FloorRepository : JpaRepository<Floor, Long> {

    @Modifying
    @Query(value = """ SELECT * FROM floor WHERE house_id = (:houseId)""", nativeQuery = true)
    fun getAllFloorsByHouseId(@Param("houseId") houseId: Long) : List<Floor>
}