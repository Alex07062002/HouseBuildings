package com.example.housebuildings.Model

import org.mapstruct.MapperConfig
import org.mapstruct.MappingInheritanceStrategy

@MapperConfig(mappingInheritanceStrategy= MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
interface MainMapper<E,Dto> {
    fun entityToDto(entity : E) : Dto
    fun dtoToEntity(dto : Dto) : E
}