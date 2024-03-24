package com.example.housebuildings.Service

import com.example.housebuildings.Model.Floor.Floor
import com.example.housebuildings.Model.Floor.FloorDTO
import com.example.housebuildings.Model.Floor.FloorMapper
import com.example.housebuildings.Repository.FlatRepository
import com.example.housebuildings.Repository.FloorRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class FloorService : CrudService<Floor, Long, FloorDTO>() {

    override val mapper: FloorMapper = Mappers.getMapper(FloorMapper::class.java)

    @Autowired
    private lateinit var floorRepository : FloorRepository

    @Autowired
    private lateinit var flatRepository: FlatRepository

    override fun validateAdd(dto: FloorDTO): Boolean{
        when{
            dto.houseId <= 0 -> {
                throw IllegalArgumentException("Floor : house id isn't be smaller than zero!")
            }
            dto.floor <= 0 -> {
                throw IllegalArgumentException("Floor : floor isn't be smaller than zero!")
            }
        }
        return true
    }

    override fun validateUpdate(dto: FloorDTO): Boolean {
        when{
            dto.id == null -> {
                throw IllegalArgumentException("Floor id isn't be null!")
            }
            dto.id <= 0 -> {
                throw IllegalArgumentException("Floor id isn't be smaller than zero!")
            }
            dto.houseId <= 0 -> {
                throw IllegalArgumentException("Floor : house id isn't be smaller than zero!")
            }
            dto.floor <= 0 -> {
                throw IllegalArgumentException("Floor : floor isn't be smaller than zero!")
            }
        }
        return true
    }

    override fun validateDelete(dto: FloorDTO): Boolean = flatRepository.getAllFlatByFloorId(dto.id!!).isEmpty()

    override fun getMainRepository(): JpaRepository<Floor, Long> = floorRepository

    fun getAllFloorByHouse(id : Long) : List<FloorDTO> = floorRepository.getAllFloorByHouseId(id).stream()
        .map { mapper.entityToDto(it) }.toList()
}