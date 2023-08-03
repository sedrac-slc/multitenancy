package com.example.multitenancy.service

import com.example.multitenancy.domain.Person
import com.example.multitenancy.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService (
    private val personRepository: PersonRepository
){

    fun save(person: Person): Person = personRepository.save(person)
    fun list(): List<Person> = personRepository.findAll()
    fun existsByEmail(email: String) = personRepository.existsByEmail(email)
    fun deleteById(id: Long) = personRepository.deleteById(id)
    fun delete(person: Person) = personRepository.delete(person)
    fun findById(id: Long) = personRepository.findById(id).orElseThrow { Exception("Not Found person by id=$id") }
}