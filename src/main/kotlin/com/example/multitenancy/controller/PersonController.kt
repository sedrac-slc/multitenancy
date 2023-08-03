package com.example.multitenancy.controller

import com.example.multitenancy.body.post.PersonPostDTO
import com.example.multitenancy.body.put.PersonPutDTO
import com.example.multitenancy.domain.Person
import com.example.multitenancy.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persons")
class PersonController(
    private val personService: PersonService
) {

    @GetMapping
    fun list()  = ResponseEntity(personService.list(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Person> = ResponseEntity(personService.findById(id), HttpStatus.OK)

    @PostMapping
    fun save(@RequestBody personDTO: PersonPostDTO): ResponseEntity<Person>{
        val person = personService.save(personDTO.person());
        return ResponseEntity(person,HttpStatus.CREATED)
    }

    @PutMapping
    fun update(@RequestBody personDTO: PersonPutDTO): ResponseEntity<Person>{
        val person = personService.save(personDTO.person());
        return ResponseEntity(person,HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id :Long): ResponseEntity<Any>{
        personService.findById(id);
        personService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}