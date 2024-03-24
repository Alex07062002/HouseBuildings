package com.example.housebuildings.Controller

import com.example.housebuildings.Model.House.HouseDTO
import com.example.housebuildings.Service.HouseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/house")
class HouseController {

    @Autowired
    private lateinit var houseService: HouseService

    @GetMapping()
    fun getAllHouse() : List<HouseDTO> = houseService.getAll()

    @PostMapping("/create")
    fun createHouse(@RequestBody houseDTO : HouseDTO) = houseService.add(houseDTO)

    @PostMapping("/delete")
    fun deleteHouse(@RequestBody houseDTO : HouseDTO) = houseService.delete(houseDTO)

    @PutMapping("/update")
    fun updateHouse(@RequestBody houseDTO : HouseDTO) = houseService.update(houseDTO)

    @GetMapping("/{id}")
    fun getHouseById(@PathVariable id : Long) : HouseDTO = houseService.getById(id)

    @GetMapping("/{cityId}")
    fun getHouseByCityId(@PathVariable cityId : Long) : List<HouseDTO> = houseService.getAllHouseByCity(cityId)

}