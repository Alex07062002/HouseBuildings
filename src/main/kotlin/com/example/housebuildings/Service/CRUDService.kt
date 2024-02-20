package com.example.housebuildings.Service

import lombok.AllArgsConstructor
import java.util.Optional


@AllArgsConstructor
abstract class CrudService<E : Any, ID : Number, Dto> : RepositoryProvider<E,ID> {

    fun getById(id: ID): Dto {
        val optionalCity: Optional<E> = getMainRepository().findById(id)
        val city: E = optionalCity.orElseThrow{IllegalArgumentException("Missing exist")}
        return mapToDto(city)
    }

    fun getAll(): List<Dto>  = getMainRepository().findAll()
            .stream()
            .map { e: E -> mapToDto(e) }
            .toList()

    protected abstract fun validateAdd(dto: Dto): Boolean
    protected abstract fun validateUpdate(dto: Dto): Boolean
    protected abstract fun validateDelete(dto: Dto): Boolean
    fun add(dto: Dto) {
        require(validateAdd(dto)) { "Bad request" }
        val entity = mapFromDto(dto)
        getMainRepository().save(entity)
    }

    fun update(dto: Dto) {
        require(validateUpdate(dto)) { "Bad request" }
        val entity = mapFromDto(dto)
        getMainRepository().save(entity)
    }

    fun delete(dto: Dto) {
        require(validateDelete(dto)) { "Bad request" }
        val entity = mapFromDto(dto)
        getMainRepository().delete(entity)
    }

    protected abstract fun mapFromDto(dto: Dto): E
    protected abstract fun mapToDto(e: E): Dto
}