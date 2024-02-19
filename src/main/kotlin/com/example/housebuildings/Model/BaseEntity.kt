package com.example.housebuildings.Model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.util.ProxyUtils

@MappedSuperclass
abstract class BaseEntity<T : Number> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: T? = null
}