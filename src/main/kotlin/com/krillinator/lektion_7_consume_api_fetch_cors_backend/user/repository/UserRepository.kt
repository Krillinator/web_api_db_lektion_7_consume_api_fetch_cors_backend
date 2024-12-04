package com.krillinator.lektion_7_consume_api_fetch_cors_backend.user.repository

import com.krillinator.lektion_7_consume_api_fetch_cors_backend.user.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<CustomUser, Long> {
}