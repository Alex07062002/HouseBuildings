package com.example.housebuildings.Controller

import com.example.housebuildings.Model.Floor.FloorDTO
import com.example.housebuildings.Service.FloorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/floor")
class FloorController {

    @Autowired
    private lateinit var floorService: FloorService

    @GetMapping()
    fun getAllFloor() : List<FloorDTO> = floorService.getAll()

    @PostMapping("/create")
    fun createFloor(@RequestBody floorDTO : FloorDTO) = floorService.add(floorDTO)

    @PostMapping("/delete")
    fun deleteFloor(@RequestBody floorDTO : FloorDTO) = floorService.delete(floorDTO)

    @PutMapping("/update")
    fun updateFloor(@RequestBody floorDTO : FloorDTO) = floorService.update(floorDTO)

    @GetMapping("/{id}")
    fun getFloorById(@PathVariable id : Long) : FloorDTO = floorService.getById(id)

    @GetMapping("/{houseId}")
    fun getFloorByHouseId(@PathVariable houseId : Long) : List<FloorDTO> = floorService.getAllFloorByHouse(houseId)

}