package com.example.housebuildings.Model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "floor")
data class Floor(

    @JoinColumn(name = "house_id", nullable = false)
    @ManyToOne(cascade = [CascadeType.ALL])
    @get: NotBlank
    val house : House? = null,

    @Column(name = "floor", nullable = false)
    @get: NotBlank
    val floor : Long? = null

) : BaseEntity<Long>()
