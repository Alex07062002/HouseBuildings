package com.example.housebuildings.Repository

import com.example.housebuildings.Model.House
import org.springframework.data.jpa.repository.JpaRepository

interface HouseRepository : JpaRepository<House, Long> {
}