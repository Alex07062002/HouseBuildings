package com.example.housebuildings.Model.Flat

import com.example.housebuildings.Model.BaseEntity
import com.example.housebuildings.Model.Floor
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank


@Entity
@Table(name = "flat")
data class Flat(
    @JoinColumn(name = "floor_id", nullable = false)
    @ManyToOne(cascade = [CascadeType.ALL])
    @get: NotBlank
    val floor : Floor? = null,

    @Column(name = "numberOfRooms", nullable = false)
    @get: NotBlank
    val numberOfRooms : Int? = null,

    @Column(name = "entrance", nullable = false)
    @get: NotBlank
    val entrance : Int? = null,

    @Column(name = "cost", nullable = false)
    @get: NotBlank
    val cost : Double? = null,

    @Column(name = "square", nullable = false)
    @get: NotBlank
    val square : Double? = null,

    @Column(name = "typeOwnerOfFlat", nullable = false)
    val typeOwnerOfFlat : TypeOwnerOfFlat = TypeOwnerOfFlat.free,

    @Column(name = "typePrice", nullable = false)
    val typePrice : TypePrice = TypePrice.full

) : BaseEntity<Long>()
