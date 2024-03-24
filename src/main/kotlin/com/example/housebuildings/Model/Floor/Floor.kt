package com.example.housebuildings.Model.Floor

import com.example.housebuildings.Model.House.House
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
@Entity
@Table(name = "floor")
class Floor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @get: NotBlank
    @Column(name = "floor_id", nullable = false)
    var id : Long? = null,

    @JoinColumn(name = "house_id", nullable = false)
    @ManyToOne(cascade = [CascadeType.ALL])
    @get: NotBlank
    var house : House? = null,

    @Column(name = "floor", nullable = false)
    @get: NotBlank
    var floor : Long? = null

)
