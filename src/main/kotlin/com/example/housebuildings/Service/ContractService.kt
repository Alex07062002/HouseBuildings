package com.example.housebuildings.Service

import com.example.housebuildings.Model.Contract.*
import com.example.housebuildings.Repository.*
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class ContractService : CrudService<Contract, Long, ContractDTO>() {

    override val mapper: ContractMapper = Mappers.getMapper(ContractMapper::class.java)

    @Autowired
    private lateinit var contractRepository: ContractRepository

    override fun validateAdd(dto: ContractDTO): Boolean{
        when {
            dto.flatId <= 0 -> {
                throw IllegalArgumentException("Contract: flat id isn't be smaller than zero!")
            }
            dto.personId <= 0 -> {
                throw IllegalArgumentException("Contract: person id isn't be smaller than zero!")
            }
            dto.flatFloorHouseCityName.isBlank() -> {
                throw IllegalArgumentException("Contract : city name isn't be null!")
            }
            dto.flatFloorHouseAddress.isBlank() -> {
                throw IllegalArgumentException("Contract : house address isn't be null!")
            }
            dto.flatFloorHouseName.isBlank() -> {
                throw IllegalArgumentException("Contract : house name isn't be null!")
            }
            dto.flatFloorHouseConstructionstartdate <= 0 -> {
                throw IllegalArgumentException("Contract : house start date isn't be smaller than zero!")
            }
            dto.flatFloorHouseConstructioncompletiondate <= 0 -> {
                throw IllegalArgumentException("Contract : house end date construction isn't be smaller than zero!")
            }
            dto.flatFloorHouseCommissioning is Number -> {
                if (dto.flatFloorHouseCommissioning <= 0) {
                    throw IllegalArgumentException("Contract : house commissioning date isn't be smaller than zero!")
                }
            }
            dto.flatFloorFloor <= 0 -> {
                throw IllegalArgumentException("Contract : floor isn't be smaller than zero!")
            }
            dto.flatNumberOfRooms <= 0 -> {
                throw IllegalArgumentException("Contract : number of rooms isn't be smaller than zero!")
            }
            dto.flatEntrance <= 0 -> {
                throw IllegalArgumentException("Contract : entrance isn't be smaller than zero!")
            }
            dto.flatCost <= 0 -> {
                throw IllegalArgumentException("Contract : cost isn't be smaller than zero!")
            }
            dto.flatSquare <= 0 -> {
                throw IllegalArgumentException("Contract : square isn't be smaller than zero!")
            }
        }
        return true
    }

    override fun validateUpdate(dto: ContractDTO): Boolean {
        when {
            dto.id == null -> {
                throw IllegalArgumentException("Contract id isn't be null!")
            }
            dto.id <= 0 -> {
                throw IllegalArgumentException("Contract id isn't be smaller than zero!")
            }
            dto.flatId <= 0 -> {
                throw IllegalArgumentException("Contract: flat id isn't be smaller than zero!")
            }
            dto.personId <= 0 -> {
                throw IllegalArgumentException("Contract: person id isn't be smaller than zero!")
            }
            dto.flatFloorHouseCityName.isBlank() -> {
                throw IllegalArgumentException("Contract : city name isn't be null!")
            }
            dto.flatFloorHouseAddress.isBlank() -> {
                throw IllegalArgumentException("Contract : house address isn't be null!")
            }
            dto.flatFloorHouseName.isBlank() -> {
                throw IllegalArgumentException("Contract : house name isn't be null!")
            }
            dto.flatFloorHouseConstructionstartdate <= 0 -> {
                throw IllegalArgumentException("Contract : house start date isn't be smaller than zero!")
            }
            dto.flatFloorHouseConstructioncompletiondate <= 0 -> {
                throw IllegalArgumentException("Contract : house end date construction isn't be smaller than zero!")
            }
            dto.flatFloorHouseCommissioning is Number -> {
                if (dto.flatFloorHouseCommissioning <= 0) {
                    throw IllegalArgumentException("Contract : house commissioning date isn't be smaller than zero!")
                }
            }
            dto.flatFloorFloor <= 0 -> {
                throw IllegalArgumentException("Contract : floor isn't be smaller than zero!")
            }
            dto.flatNumberOfRooms <= 0 -> {
                throw IllegalArgumentException("Contract : number of rooms isn't be smaller than zero!")
            }
            dto.flatEntrance <= 0 -> {
                throw IllegalArgumentException("Contract : entrance isn't be smaller than zero!")
            }
            dto.flatCost <= 0 -> {
                throw IllegalArgumentException("Contract : cost isn't be smaller than zero!")
            }
            dto.flatSquare <= 0 -> {
                throw IllegalArgumentException("Contract : square isn't be smaller than zero!")
            }
        }
        return true
    }

    override fun validateDelete(dto: ContractDTO): Boolean = false //FIXME (don't fix) -> impossible delete -> cancelled

    override fun getMainRepository(): JpaRepository<Contract, Long> = contractRepository

    fun getAllContractByPerson(id : Long) : List<ContractDTO> = contractRepository.getAllFlatByPersonId(id).stream()
        .map{ mapper.entityToDto(it)}.toList()

    fun getAllContractByFlat(id : Long) : List<ContractDTO> = contractRepository.getAllContractByFlatId(id).stream()
        .map{mapper.entityToDto(it)}.toList()
}