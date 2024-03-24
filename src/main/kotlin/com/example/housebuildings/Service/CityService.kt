package com.example.housebuildings.Service

import com.example.housebuildings.Model.City.City
import com.example.housebuildings.Model.City.CityDTO
import com.example.housebuildings.Model.City.CityMapper
import com.example.housebuildings.Repository.CityRepository
import com.example.housebuildings.Repository.HouseRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CityService : CrudService<City, Long, CityDTO>() {

    override val mapper: CityMapper = Mappers.getMapper(CityMapper::class.java)

    @Autowired
    private lateinit var cityRepository: CityRepository

    @Autowired
    private lateinit var houseRepository: HouseRepository

    override fun getMainRepository(): JpaRepository<City, Long> = cityRepository

    override fun validateAdd(dto: CityDTO): Boolean =
        if (dto.name.isNotBlank()) true else throw IllegalArgumentException("Field 'name' can't be null!")

    override fun validateUpdate(dto: CityDTO): Boolean =
        if (dto.name.isNotBlank()) true else throw IllegalArgumentException("Field 'name' can't be null!")

    override fun validateDelete(dto: CityDTO): Boolean =
        houseRepository.getAllHouseByCityId(dto.id!!).isEmpty()

    fun getCityByName(name : String) : CityDTO = mapper.entityToDto(cityRepository.getCityByName(name))
}