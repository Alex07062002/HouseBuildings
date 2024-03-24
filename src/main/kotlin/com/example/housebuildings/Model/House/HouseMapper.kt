package com.example.housebuildings.Model.House

import com.example.housebuildings.Model.City.City
import com.example.housebuildings.Model.MainMapper
import com.example.housebuildings.Repository.CityRepository
import jakarta.persistence.EntityNotFoundException
import org.mapstruct.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
abstract class HouseMapper : MainMapper<House, HouseDTO> {

    @Autowired
    private lateinit var cityRepository: CityRepository

    /**
     * class House(
     *     var id : Long? = null,
     *     val city : City? = null,
     *     val address: String = "",
     *     val name: String = "",
     *     val constructionStartDate : Long? = null,
     *     val constructionCompletionDate: Long? = null,
     *     val commissioning: Long? = null)
     *
     *     data class HouseDTO(val id : Long?,
     *                     val cityId : Long,
     *                     val address: String,
     *                     val name: String,
     *                     val constructionStartDate : Long,
     *                     val constructionCompletionDate: Long,
     *                     val commissioning: Long?)
     */

    @Mappings(
        Mapping(target = "city", source = "cityId", qualifiedByName = ["getCityId"])
    )

    abstract override fun dtoToEntity(dto: HouseDTO): House

    @Named("getCityId")
    fun getCityId(cityId : Long) : City {
        return cityRepository.findById(cityId).orElseThrow{
            throw EntityNotFoundException("Unable to find city with id $cityId")
        }
    }

    @Mappings(
        Mapping(target = "cityId", source = "city.id")
    )

    abstract override fun entityToDto(entity: House): HouseDTO
}