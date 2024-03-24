package com.example.housebuildings.Service

import com.example.housebuildings.Model.Flat.Flat
import com.example.housebuildings.Model.Flat.FlatDTO
import com.example.housebuildings.Model.Flat.FlatMapper
import com.example.housebuildings.Repository.ContractRepository
import com.example.housebuildings.Repository.FlatRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class FlatService : CrudService<Flat, Long, FlatDTO>() {

    override val mapper: FlatMapper = Mappers.getMapper(FlatMapper::class.java)

    @Autowired
    private lateinit var flatRepository : FlatRepository

    @Autowired
    private lateinit var contractRepository : ContractRepository

    override fun getMainRepository(): JpaRepository<Flat, Long>  = flatRepository


    override fun validateAdd(dto: FlatDTO): Boolean{
        when{
            dto.floorId <= 0 -> {
                throw IllegalArgumentException("Flat : floor id isn't be smaller than zero!")
            }
            dto.numberOfRooms <= 0 -> {
                throw IllegalArgumentException("Flat : number of rooms isn't be smaller than zero!")
            }
            dto.entrance <= 0 -> {
                throw IllegalArgumentException("Flat : entrance isn't be smaller than zero!")
            }
            dto.cost <= 0 -> {
                throw IllegalArgumentException("Flat : cost isn't be smaller than zero!")
            }
            dto.square <= 0 -> {
                throw IllegalArgumentException("Flat : square isn't be smaller than zero!")
            }
        }
        return true
    }

    override fun validateUpdate(dto: FlatDTO): Boolean {
        when{
            dto.id == null -> {
                throw IllegalArgumentException("Flat id isn't be null!")
            }
            dto.id <= 0 -> {
                throw IllegalArgumentException("Flat id isn't be smaller than zero!")
            }
            dto.floorId <= 0 -> {
                throw IllegalArgumentException("Flat : floor id isn't be smaller than zero!")
            }
            dto.numberOfRooms <= 0 -> {
                throw IllegalArgumentException("Flat : number of rooms isn't be smaller than zero!")
            }
            dto.entrance <= 0 -> {
                throw IllegalArgumentException("Flat : entrance isn't be smaller than zero!")
            }
            dto.cost <= 0 -> {
                throw IllegalArgumentException("Flat : cost isn't be smaller than zero!")
            }
            dto.square <= 0 -> {
                throw IllegalArgumentException("Flat : square isn't be smaller than zero!")
            }
        }
        return true
    }

    override fun validateDelete(dto: FlatDTO): Boolean = contractRepository.getAllFlatByPersonId(dto.id!!).isEmpty()


    fun getAllFlatByFloor(floorId: Long) : List<FlatDTO> = flatRepository.getAllFlatByFloorId(floorId)
        .stream().map { mapper.entityToDto(it) }.toList()

}