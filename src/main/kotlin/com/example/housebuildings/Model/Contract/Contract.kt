package com.example.housebuildings.Model.Contract

import com.example.housebuildings.Model.BaseEntity
import com.example.housebuildings.Model.Flat.Flat
import com.example.housebuildings.Model.Person.Person
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties

@Entity
@Table(name = "contract")
data class Contract (

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "flat_id", nullable = false)
    @get: NotBlank
    val flat : Flat? = null,


    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "person_id", nullable = false)
    @get: NotBlank
    val person : Person? = null,

    @Column(name = "typeOfPay", nullable = false)
    val typeOfPay : TypeOfPay = TypeOfPay.cash,

    @Column(name = "statusOfContract", nullable = false)
    val statusOfContract : StatusOfContract = StatusOfContract.created
    ) : BaseEntity<Long>()
