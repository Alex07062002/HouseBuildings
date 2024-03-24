package com.example.housebuildings.Model.House

import com.example.housebuildings.Model.City.City
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
@Entity
@Table(name = "house")
class House(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @get: NotBlank
    @Column(name = "house_id", nullable = false)
    var id : Long? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @get: NotBlank
    @JoinColumn(name = "city_id", nullable = false)
    var city : City? = null,

    @get: NotBlank
    @Column(name = "address", nullable = false)
    var address: String = "",

    @get: NotBlank
    @Column(name = "name", nullable = false)
    var name: String = "",

    @get: NotBlank
    @Column (name = "constructionStartDate", nullable = false)
    var constructionStartDate : Long? = null,

    @get: NotBlank
    @Column( name = "constructionCompletionDate", nullable = false)
    var constructionCompletionDate: Long? = null,

    @Column( name = "commissioning")
    var commissioning: Long? = null
)
