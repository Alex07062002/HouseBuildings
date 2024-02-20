package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Contract.Contract
import com.example.housebuildings.Model.Contract.StatusOfContract
import com.example.housebuildings.Model.Flat.Flat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ContractRepository : JpaRepository<Contract, Long> {

    @Modifying
    @Query(value = """ SELECT * FROM contract WHERE person_id = (:personId)""", nativeQuery = true)
    fun getAllFlatByFloorId(@Param("personId") personId: Long) : List<Contract>

    @Modifying
    @Query(value = """ UPDATE contract SET status_of_contract = (:statusOfContract)
        | WHERE contract_id = (:contractId)""", nativeQuery = true)
    fun updateStatusInContract(@Param("statusOfContract") statusOfContract : StatusOfContract,
                               @Param("contractId") contractId : Long) : List<Contract>

}