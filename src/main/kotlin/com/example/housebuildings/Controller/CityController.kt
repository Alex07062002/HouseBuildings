package com.example.housebuildings.Controller

import com.example.housebuildings.Model.City.CityDTO
import com.example.housebuildings.Service.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/city")
class CityController {

    @Autowired
    private lateinit var cityService : CityService

    @GetMapping()
    fun getAllCity() : List<CityDTO> = cityService.getAll()

    @PostMapping("/create")
    fun createCity(@RequestBody cityDTO : CityDTO) = cityService.add(cityDTO)

    @PostMapping("/delete")
    fun deleteCity(@RequestBody cityDTO : CityDTO) = cityService.delete(cityDTO)

    @PutMapping("/update")
    fun updateCity(@RequestBody cityDTO : CityDTO) = cityService.update(cityDTO)

    @GetMapping("/{id}")
    fun getCityById(@PathVariable id : Long) : CityDTO = cityService.getById(id)

    @GetMapping("/{name}")
    fun getCityByName(@PathVariable name : String) : CityDTO = cityService.getCityByName(name)

}