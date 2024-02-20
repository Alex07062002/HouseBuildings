package com.example.housebuildings.Service

import com.example.housebuildings.Model.City
import com.example.housebuildings.Repository.CityRepository
import com.example.housebuildings.Repository.HouseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CityService : CrudService<City, Long, City>() {

    @Autowired
    private lateinit var  cityRepository : CityRepository
    @Autowired
    private lateinit var houseRepository: HouseRepository

    override fun getMainRepository(): JpaRepository<City, Long> = cityRepository

    override fun validateAdd(dto: City): Boolean {
        TODO("Not yet implemented")
    }

    override fun validateUpdate(dto: City): Boolean {
        TODO("Not yet implemented")
    }

    override fun validateDelete(dto: City): Boolean {
        TODO("Not yet implemented")
    }

    override fun mapFromDto(dto: City): City {
        TODO("Not yet implemented")
    }

    override fun mapToDto(e: City): City {
        TODO("Not yet implemented")
    }

    fun getAllCity() : List<City> = cityRepository.findAll()

    fun createCity(){}

    fun updateCity(){}

    fun getCityById(){}

    fun deleteCity(){}


}