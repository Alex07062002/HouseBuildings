package com.example.housebuildings.Service

import org.springframework.data.jpa.repository.JpaRepository

interface RepositoryProvider<E, ID> {
    fun getMainRepository() : JpaRepository<E, ID>
}
