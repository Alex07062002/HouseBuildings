package com.example.housebuildings.Model.Flat

import com.example.housebuildings.Model.Floor.Floor
import com.example.housebuildings.Repository.FloorRepository
import com.example.housebuildings.Model.MainMapper
import jakarta.persistence.EntityNotFoundException
import org.mapstruct.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
abstract class FlatMapper : MainMapper<Flat, FlatDTO> {

    @Autowired
    private lateinit var floorRepository: FloorRepository

    /**
     * class Flat(
     *     var id : Long? = null,
     *     val floor : Floor? = null,
     *     val numberOfRooms : Int? = null,
            val entrance : Int? = null,
     *     val cost : Double? = null,
     *     val square : Double? = null,
     *     val typeOwnerOfFlat : TypeOwnerOfFlat = TypeOwnerOfFlat.free,
     *     val typePrice : TypePrice = TypePrice.full)
     *
     *     FlatDTO(val id : Long?,
     *                    val floorId : Long,
     *                    val numberOfRooms : Int,
     *                    val entrance : Int,
     *                    val cost : Double,
     *                    val square : Double,
     *                    val typeOwnerOfFlat : TypeOwnerOfFlat = TypeOwnerOfFlat.free,
     *                    val typePrice : TypePrice = TypePrice.full)
     *
     */

    @Mappings(
        Mapping(target = "floor", source = "floorId", qualifiedByName = ["getFloorId"])
    )

    abstract override fun dtoToEntity(dto: FlatDTO): Flat

    @Named("getFloorId")
    fun getFloorId(floorId : Long) : Floor {
        return this.floorRepository.findById(floorId).orElseThrow {
            throw EntityNotFoundException("Unable to find floor with id $floorId")
        }
    }

    @Mappings(
        Mapping(target = "floorId", source = "floor.id")
    )

    abstract override fun entityToDto(entity: Flat): FlatDTO
}