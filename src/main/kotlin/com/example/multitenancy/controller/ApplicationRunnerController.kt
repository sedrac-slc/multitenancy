package com.example.multitenancy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("runners")
class ApplicationRunnerController {

    @GetMapping
    fun updateAllRunner(){

    }

}