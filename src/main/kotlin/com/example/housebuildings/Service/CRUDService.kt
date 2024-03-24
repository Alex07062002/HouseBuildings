package com.example.housebuildings.Service

import com.example.housebuildings.Model.MainMapper
import lombok.AllArgsConstructor
import java.util.Optional

@AllArgsConstructor
abstract class CrudService<E : Any, ID : Number, Dto> : RepositoryProvider<E,ID>{

    abstract val mapper : MainMapper<E, Dto>

    fun getById(id: ID): Dto {
        val optionalEntity: Optional<E> = getMainRepository().findById(id)
        val entity: E = optionalEntity.orElseThrow{IllegalArgumentException("Missing exist")}
        return mapper.entityToDto(entity)
    }

    fun getAll(): List<Dto>  = getMainRepository().findAll()
            .stream()
            .map { entity: E -> mapper.entityToDto(entity)}
            .toList()

    protected abstract fun validateAdd(dto: Dto): Boolean
    protected abstract fun validateUpdate(dto: Dto): Boolean
    protected abstract fun validateDelete(dto: Dto): Boolean

    fun add(dto: Dto) {
        require(validateAdd(dto)) { throw IllegalArgumentException("Impossible create entity") }
        val entity = mapper.dtoToEntity(dto)
        getMainRepository().save(entity)
    }

    fun update(dto: Dto) {
        require(validateUpdate(dto)) { throw IllegalArgumentException("Impossible update entity") }
        val entity = mapper.dtoToEntity(dto)
        getMainRepository().save(entity)
    }

    fun delete(dto: Dto) {
        require(validateDelete(dto)) { throw IllegalArgumentException("Impossible delete entity") }
        val entity = mapper.dtoToEntity(dto)
        getMainRepository().delete(entity)
    }
}