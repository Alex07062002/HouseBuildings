package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Person.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>