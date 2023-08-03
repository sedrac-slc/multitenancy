package com.example.multitenancy.domain

import jakarta.persistence.*

@Entity
@Table(name = "tb_persons")
class Person (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var name: String,
    @Column(unique = true)
    var email: String
)