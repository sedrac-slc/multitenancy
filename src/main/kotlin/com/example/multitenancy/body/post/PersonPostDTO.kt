package com.example.multitenancy.body.post

import com.example.multitenancy.domain.Person

data class PersonPostDTO (
    var name: String,
    var email: String
){
    fun person(): Person = Person(null,name, email)
}