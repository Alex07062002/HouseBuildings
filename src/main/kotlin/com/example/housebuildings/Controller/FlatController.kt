package com.example.housebuildings.Controller

import com.example.housebuildings.Model.Flat.FlatDTO
import com.example.housebuildings.Service.FlatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/flat")
class FlatController {

    @Autowired
    private lateinit var flatService : FlatService

    @GetMapping()
    fun getAllFlat() : List<FlatDTO> = flatService.getAll()

    @PostMapping("/create")
    fun createFlat(@RequestBody flatDTO : FlatDTO) = flatService.add(flatDTO)

    @PostMapping("/delete")
    fun deleteFlat(@RequestBody flatDTO : FlatDTO) = flatService.delete(flatDTO)

    @PutMapping("/update")
    fun updateFlat(@RequestBody flatDTO : FlatDTO) = flatService.update(flatDTO)

    @GetMapping("/{id}")
    fun getFlatById(@PathVariable id : Long) : FlatDTO = flatService.getById(id)

    @GetMapping("/{floorId}")
    fun getFlatByFloor(@PathVariable floorId : Long) : List<FlatDTO> = flatService.getAllFlatByFloor(floorId)
}