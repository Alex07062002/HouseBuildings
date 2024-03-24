package com.example.housebuildings.Service

import com.example.housebuildings.Model.Person.Person
import com.example.housebuildings.Model.Person.PersonDTO
import com.example.housebuildings.Model.Person.PersonMapper
import com.example.housebuildings.Model.Person.Role
import com.example.housebuildings.Repository.PersonRepository
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class PersonService : CrudService<Person, Long, PersonDTO>() {

    override val mapper: PersonMapper = Mappers.getMapper(PersonMapper::class.java)

    @Autowired
    private lateinit var personRepository : PersonRepository

    override fun validateAdd(dto: PersonDTO): Boolean {
       when {
           dto.name.isBlank() -> {
               throw IllegalArgumentException("Person : name isn't be null!")
           }
           dto.surname.isBlank() -> {
               throw IllegalArgumentException("Person : surname isn't be null!")
           }
           dto.email.isBlank() -> {
               throw IllegalArgumentException("Person : email isn't be null!")
           }// TODO Validator email
           dto.login.isBlank() -> {
               throw IllegalArgumentException("Person : login isn't be null!")
           }
           dto.password.isBlank() -> {
               throw IllegalArgumentException("Person : password isn't be null!")
           }
       }
        return true
    }

    override fun validateUpdate(dto: PersonDTO): Boolean {
        when {
            dto.id == null -> {
                throw IllegalArgumentException("Person id isn't be null!")
            }
            dto.id <= 0 -> {
                throw IllegalArgumentException("Person id isn't be smaller than zero!")
            }
            dto.name.isBlank() -> {
                throw IllegalArgumentException("Person : name isn't be null!")
            }
            dto.surname.isBlank() -> {
                throw IllegalArgumentException("Person : surname isn't be null!")
            }
            dto.email.isBlank() -> {
                throw IllegalArgumentException("Person : email isn't be null!")
            }// TODO Validator email
            dto.login.isBlank() -> {
                throw IllegalArgumentException("Person : login isn't be null!")
            }
            dto.password.isBlank() -> {
                throw IllegalArgumentException("Person : password isn't be null!")
            }
        }
        return true
    }

    override fun validateDelete(dto: PersonDTO): Boolean = false

    override fun getMainRepository(): JpaRepository<Person, Long> = personRepository
}