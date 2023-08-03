package com.example.multitenancy.runner

import com.example.multitenancy.body.post.PersonPostDTO
import com.example.multitenancy.config.TenantContext
import com.example.multitenancy.service.PersonService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class PersonRunner(
    private val personService: PersonService,
): ApplicationRunner{

    override fun run(args: ApplicationArguments?) {
        listOf(
            PersonPostDTO("Sedrac","sedrac@gmail.com"),
            PersonPostDTO("Maria","maria@gmail.com"),
            PersonPostDTO("João","joao@gmail.com")
        ).filter { !personService.existsByEmail(it.email) }.forEach { personService.save(it.person()) }
    }

}