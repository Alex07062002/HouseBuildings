package com.example.housebuildings.Model.Contract

import com.example.housebuildings.Model.Flat.Flat
import com.example.housebuildings.Model.Person.Person
import com.example.housebuildings.Repository.*
import com.example.housebuildings.Model.MainMapper
import jakarta.persistence.EntityNotFoundException
import org.mapstruct.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
abstract class ContractMapper : MainMapper<Contract, ContractDTO> {

    @Autowired
    private lateinit var personRepository : PersonRepository

    @Autowired
    private lateinit var flatRepository: FlatRepository

    /**
     * Contract
     * var id : Long? = null,
     * val flat : Flat? = null,
     * val person : Person? = null,
     * val typeOfPay : TypeOfPay = TypeOfPay.cash,
     * val statusOfContract : StatusOfContract = StatusOfContract.created
     *
     * ContractDTO
     * val id : Long?,
     *                        val flatId : Long,
     *                        val personId : Long,
     *                        val flatFloorHouseCityName : String,
     *                        val flatFloorHouseAddress : String,
     *                        val flatFloorHouseName : String,
     *                        val flatFloorHouseConstructionstartdate : Long,
     *                        val flatFloorHouseConstructioncompletiondate : Long,
     *                        val flatFloorHouseCommissioning : Long?,
     *                        val flatFloorFloor : Long,
     *                        val flatNumberOfRooms : Int,
     *                        val flatEntrance : Int,
     *                        val flatCost : Double,
     *                        val flatSquare : Double,
     *                        val flatTypeOwnerOfFlat : TypeOwnerOfFlat,
     *                        val flatTypePrice : TypePrice,
     *                        val typeOfPay : TypeOfPay,
     *                        val status : StatusOfContract
     */

    @Mappings(
        Mapping(target = "flat", source = "flatId", qualifiedByName = ["getFlatId"]),
        Mapping( target = "person", source = "personId", qualifiedByName = ["getPersonId"]),
    )

    @Named("getFlatId")
    fun getFlatId(flatId: Long): Flat {
        return this.flatRepository.findById(flatId).orElseThrow {
            throw EntityNotFoundException("Unable to find flat with id $flatId")
        }
    }

    @Named("getPersonId")
    fun getPersonId(personId: Long): Person {
        return this.personRepository.findById(personId).orElseThrow {
            throw EntityNotFoundException("Unable to find person with id $personId")
        }
    }

    abstract override fun dtoToEntity(dto: ContractDTO): Contract

    @Mappings(
        Mapping(target = "flatId", source = "flat.id"),
        Mapping(target = "flatFloorHouseCityName", source = "flat.floor.house.city.name"),
        Mapping(target = "flatFloorHouseAddress", source = "flat.floor.house.address"),
        Mapping(target = "flatFloorHouseName", source = "flat.floor.house.name"),
        Mapping(target = "flatFloorHouseConstructionstartdate", source = "flat.floor.house.constructionStartDate"),
        Mapping(target = "flatFloorHouseConstructioncompletiondate", source = "flat.floor.house.constructionCompletionDate"),
        Mapping(target = "flatFloorHouseCommissioning", source = "flat.floor.house.commissioning"),
        Mapping(target = "flatFloorFloor", source = "flat.floor.floor"),
        Mapping(target = "flatNumberOfRooms", source = "flat.numberOfRooms"),
        Mapping(target = "flatEntrance", source = "flat.entrance"),
        Mapping(target = "flatCost", source = "flat.cost"),
        Mapping(target = "flatSquare", source = "flat.square"),
        Mapping(target = "flatTypeOwnerOfFlat", source = "flat.typeOwnerOfFlat"),
        Mapping(target = "flatTypePrice", source = "flat.typePrice"),
    )

    abstract override fun entityToDto(entity: Contract): ContractDTO

}