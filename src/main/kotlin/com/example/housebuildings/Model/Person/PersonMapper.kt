package com.example.housebuildings.Model.Person

import com.example.housebuildings.Model.MainMapper
import org.mapstruct.*
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
abstract class PersonMapper : MainMapper<Person, PersonDTO> {

    /**
     * class Person(
     *     var id : Long? = null,
     *     val nameSurname : String = "",
     *     val email : String = "",
     *     val login : String = "",
     *     val password : String = "",
     *     val role : Role = Role.user)
     *
     * data class PersonDTO(val id : Long?,
     *                      val name : String,
     *                      val surname : String,
     *                      val email : String,
     *                      val login : String,
     *                      val password : String,
     *                      val role : Role = Role.user)
     *
     * data class PersonRegisterDTO(
     * val name : String,
     * val surname : String,
     * val email : String,
     * val login : String,
     * val password : String,
     * val passwordConfirm : String)
     *
     * data class PersonUpdateDTO(val name : String,
     *                            val surname : String,
     *                            val email : String)
     *
     */

    @Mappings(
        Mapping(target = "nameSurname", expression = "java(dto.getName()+\" \"+dto.getSurname())")
    )

    abstract override fun dtoToEntity(dto: PersonDTO): Person

    @Mappings(
        Mapping(target = "name", source = "nameSurname", qualifiedByName = ["getName"]),
        Mapping(target = "surname", source = "nameSurname", qualifiedByName = ["getSurname"]),
        )
    abstract override fun entityToDto(entity: Person): PersonDTO

    @Named("getName")
    fun getName(nameSurname : String) : String = nameSurname.split(" ")[0]

    @Named("getSurname")
    fun getSurname(nameSurname : String) : String = nameSurname.split(" ")[1]

    @Mappings(
        Mapping(target = "nameSurname", expression = "java(registerDTO.getName()+\" \"+ registerDTO.getSurname())")

    )

    abstract fun registerDTOToEntity(registerDTO: PersonRegisterDTO) : Person

    @Mappings(
        Mapping(target = "name", source = "nameSurname", qualifiedByName = ["getName"]),
        Mapping(target = "surname", source = "nameSurname", qualifiedByName = ["getSurname"]),
    )
    abstract fun entityToUpdatePerson(person : Person) : PersonUpdateDTO

}