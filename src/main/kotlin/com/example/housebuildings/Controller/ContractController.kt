package com.example.housebuildings.Controller

import com.example.housebuildings.Model.Contract.ContractDTO
import com.example.housebuildings.Service.ContractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contract")
class ContractController {

    @Autowired
    private lateinit var contractService : ContractService

    @GetMapping()
    fun getAllContract() : List<ContractDTO> = contractService.getAll()

    @PostMapping("/create")
    fun createContract(@RequestBody contractDTO : ContractDTO) = contractService.add(contractDTO)

    @PostMapping("/delete")
    fun deleteContract(@RequestBody contractDTO : ContractDTO) = contractService.delete(contractDTO)

    @PutMapping("/update")
    fun updateContract(@RequestBody contractDTO : ContractDTO) = contractService.update(contractDTO)

    @GetMapping("/{id}")
    fun getContractById(@PathVariable id : Long) : ContractDTO = contractService.getById(id)

    @GetMapping("/{personId}")
    fun getContractByPerson(@PathVariable personId : Long) : List<ContractDTO> = contractService.getAllContractByPerson(personId)

    @GetMapping("/{flatId}")
    fun getContractByFlat(@PathVariable flatId : Long) : List<ContractDTO> = contractService.getAllContractByFlat(flatId)

}