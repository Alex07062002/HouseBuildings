package com.example.housebuildings.Repository

import com.example.housebuildings.Model.Contract.Contract
import org.springframework.data.jpa.repository.JpaRepository

interface ContractRepository : JpaRepository<Contract, Long> {
}