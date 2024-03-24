package com.example.housebuildings.Model.Contract

import com.example.housebuildings.Model.Flat.Flat
import com.example.housebuildings.Model.Person.Person
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
@Entity
@Table(name = "contract")
class Contract (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @get: NotBlank
    @Column(name = "contract_id", nullable = false)
    var id : Long? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "flat_id", nullable = false)
    @get: NotBlank
    val flat : Flat? = null,


    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "person_id", nullable = false)
    @get: NotBlank
    val person : Person? = null,

    @Column(name = "typeOfPay", nullable = false)
    @Enumerated(EnumType.STRING)
    val typeOfPay : TypeOfPay = TypeOfPay.cash,

    @Column(name = "statusOfContract", nullable = false)
    @Enumerated(EnumType.STRING)
    val statusOfContract : StatusOfContract = StatusOfContract.created
    )
