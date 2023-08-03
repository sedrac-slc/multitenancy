package com.example.multitenancy.repository

import com.example.multitenancy.domain.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person,Long>{
    fun existsByEmail(email: String): Boolean
}