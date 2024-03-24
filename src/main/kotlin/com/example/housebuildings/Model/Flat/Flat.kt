package com.example.housebuildings.Model.Flat

import com.example.housebuildings.Model.Floor.Floor
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
@Entity
@Table(name = "flat")
class Flat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @get: NotBlank
    @Column(name = "flat_id", nullable = false)
    var id : Long? = null,

    @JoinColumn(name = "floor_id", nullable = false)
    @ManyToOne(cascade = [CascadeType.ALL])
    @get: NotBlank
    var floor : Floor? = null,

    @Column(name = "numberOfRooms", nullable = false)
    @get: NotBlank
    var numberOfRooms : Int? = null,

    @Column(name = "entrance", nullable = false)
    @get: NotBlank
    var entrance : Int? = null,

    @Column(name = "cost", nullable = false)
    @get: NotBlank
    var cost : Double? = null,

    @Column(name = "square", nullable = false)
    @get: NotBlank
    var square : Double? = null,

    @Column(name = "typeOwnerOfFlat", nullable = false)
    @Enumerated(EnumType.STRING)
    var typeOwnerOfFlat : TypeOwnerOfFlat = TypeOwnerOfFlat.free,

    @Column(name = "typePrice", nullable = false)
    @Enumerated(EnumType.STRING)
    var typePrice : TypePrice = TypePrice.full

)
