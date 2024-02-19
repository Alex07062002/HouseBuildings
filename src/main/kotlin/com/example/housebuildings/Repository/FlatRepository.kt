package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Flat.Flat
import org.springframework.data.jpa.repository.JpaRepository

interface FlatRepository : JpaRepository<Flat, Long> {
}