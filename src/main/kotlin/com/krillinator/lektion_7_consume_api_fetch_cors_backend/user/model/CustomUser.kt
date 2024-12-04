package com.krillinator.lektion_7_consume_api_fetch_cors_backend.user.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Entity
class CustomUser(

    @field:NotEmpty
    @field:Size(min = 2, max = 32)
    val username: String = "",

    @field:NotEmpty
    @field:Size(min = 7, max = 128)
    val password: String = "",

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null
) {
}