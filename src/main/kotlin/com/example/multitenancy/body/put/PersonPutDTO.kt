package com.example.multitenancy.body.put

import com.example.multitenancy.domain.Person

data class PersonPutDTO (
    var id: Long,
    var name: String,
    var email: String
){
    fun person(): Person = Person(id,name, email)
}