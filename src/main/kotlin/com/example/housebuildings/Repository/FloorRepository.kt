package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Floor
import org.springframework.data.jpa.repository.JpaRepository

interface FloorRepository : JpaRepository<Floor, Long> {
}