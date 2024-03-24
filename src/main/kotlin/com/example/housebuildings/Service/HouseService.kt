package com.example.housebuildings.Service

import com.example.housebuildings.Model.House.House
import com.example.housebuildings.Model.House.HouseDTO
import com.example.housebuildings.Model.House.HouseMapper
import com.example.housebuildings.Repository.FloorRepository
import com.example.housebuildings.Repository.HouseRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class HouseService : CrudService<House, Long, HouseDTO>() {

    override val mapper: HouseMapper = Mappers.getMapper(HouseMapper::class.java)

    @Autowired
    private lateinit var houseRepository: HouseRepository

    @Autowired
    private lateinit var floorRepository: FloorRepository

    override fun validateAdd(dto: HouseDTO): Boolean {
        when{
            dto.cityId <= 0 -> {
                throw IllegalArgumentException("House : city id isn't be smaller than zero!")
            }
            dto.address.isBlank() -> {
                throw IllegalArgumentException("House : address isn't be null!")
            }
            dto.name.isBlank() -> {
                throw IllegalArgumentException("House : name isn't be null!")
            }
            dto.constructionStartDate <= 0 -> {
                throw IllegalArgumentException("House : start date isn't be smaller than zero!")
            }
            dto.constructionCompletionDate <= 0 -> {
                throw IllegalArgumentException("House : complete date isn't be smaller than zero!")
            }
            dto.commissioning is Number -> {
                if (dto.commissioning <= 0){
                    throw IllegalArgumentException("House : commissioning isn't be smaller than zero!")
                }
            }
        }
        return true
    }

    override fun validateUpdate(dto: HouseDTO): Boolean {
        when{
            dto.id == null -> {
                throw IllegalArgumentException("House id isn't be null!")
            }
            dto.id <= 0 -> {
                throw IllegalArgumentException("House id isn't be smaller than zero!")
            }
            dto.cityId <= 0 -> {
                throw IllegalArgumentException("House : city id isn't be smaller than zero!")
            }
            dto.address.isBlank() -> {
                throw IllegalArgumentException("House : address isn't be null!")
            }
            dto.name.isBlank() -> {
                throw IllegalArgumentException("House : name isn't be null!")
            }
            dto.constructionStartDate <= 0 -> {
                throw IllegalArgumentException("House : start date isn't be smaller than zero!")
            }
            dto.constructionCompletionDate <= 0 -> {
                throw IllegalArgumentException("House : complete date isn't be smaller than zero!")
            }
            dto.commissioning is Number -> {
                if (dto.commissioning <= 0){
                    throw IllegalArgumentException("House : commissioning isn't be smaller than zero!")
                }
            }
        }
        return true
    }

    override fun validateDelete(dto: HouseDTO): Boolean = floorRepository.getAllFloorByHouseId(dto.id!!).isEmpty()

    override fun getMainRepository(): JpaRepository<House, Long> = houseRepository

    fun getAllHouseByCity(id: Long) : List<HouseDTO> = houseRepository.getAllHouseByCityId(id).stream()
        .map{ mapper.entityToDto(it)}.toList()

}