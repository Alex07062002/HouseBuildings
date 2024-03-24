package com.example.housebuildings.Model.Floor

import com.example.housebuildings.Model.House.House
import com.example.housebuildings.Model.MainMapper
import com.example.housebuildings.Repository.HouseRepository
import jakarta.persistence.EntityNotFoundException
import org.mapstruct.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
abstract class FloorMapper : MainMapper<Floor, FloorDTO> {

    @Autowired
    private lateinit var houseRepository : HouseRepository

    /**
     * class Floor(
     *     var id : Long? = null,
     *     val house : House? = null,
     *     val floor : Long? = null)
     *
     *     FloorDTO(val id : Long?, val houseId : Long, val floor : Long)
     */

    @Mappings(
        Mapping(target = "house", source = "houseId", qualifiedByName = ["getHouseId"])
    )
    abstract override fun dtoToEntity(dto: FloorDTO): Floor

    @Named("getHouseId")
    fun getHouseId(houseId : Long) : House{
        return houseRepository.findById(houseId).orElseThrow {
            throw EntityNotFoundException("Unable to find house with id $houseId")
        }
    }

    @Mappings(
        Mapping(target = "houseId", source = "house.id")
    )
    abstract override fun entityToDto(entity: Floor): FloorDTO
}