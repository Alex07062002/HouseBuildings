package com.example.housebuildings.Controller

import com.example.housebuildings.Model.Person.PersonDTO
import com.example.housebuildings.Service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController { //FIXME add security!!!

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping()
    fun getAllPerson() : List<PersonDTO> = personService.getAll()

  /*  @PostMapping("/create")
    fun createPerson(@RequestBody houseDTO : HouseDTO) = personService.add(houseDTO)

    @PostMapping("/delete")
    fun deleteHouse(@RequestBody houseDTO : HouseDTO) = personService.delete(houseDTO)

    @PutMapping("/update")
    fun updateHouse(@RequestBody houseDTO : HouseDTO) = personService.update(houseDTO)
*/
}