package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Contract.Contract
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ContractRepository : JpaRepository<Contract, Long> {

    @Modifying
    @Query(value = """ SELECT * FROM contract WHERE person_id = (:personId)""", nativeQuery = true)
    fun getAllFlatByPersonId(@Param("personId") personId: Long) : List<Contract>

    @Modifying
    @Query(value = """SELECT * from contract WHERE flat_id = (:flatId)""", nativeQuery = true)
    fun getAllContractByFlatId(@Param("flatId") flatId : Long) : List<Contract>
}