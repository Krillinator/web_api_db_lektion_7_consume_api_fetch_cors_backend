package com.krillinator.lektion_7_consume_api_fetch_cors_backend.user.controller

import com.krillinator.lektion_7_consume_api_fetch_cors_backend.user.model.CustomUser
import com.krillinator.lektion_7_consume_api_fetch_cors_backend.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("api/v1/user")
class UserController(
    @Autowired val userRepository: UserRepository
) {

    // localhost:8080/api/v1/user
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<CustomUser>> {

        val result: List<CustomUser> = userRepository.findAll()

        return ResponseEntity.ok(result)
    }

    // TODO - localhost:8080/clothes/shirts?color=blue       - RequestParam
    // TODO - localhost:8080/user/{userName}/task/{taskName} - PathVariable
    // localhost:8080/api/v1/user/{id}
    // TODO - TEST without /
    @GetMapping("/{id}")
    fun getUserByUserId(
        @PathVariable id: Long
    ): ResponseEntity<CustomUser> {

        val foundUserById: Optional<CustomUser> = userRepository.findById(id)

        if (foundUserById.isPresent) {
            return ResponseEntity.ok(foundUserById.get())
        }

        return ResponseEntity.notFound().build()
    }

    // localhost:8080/api/v1/user
    @PostMapping
    fun postUser(@RequestBody customUser: CustomUser): ResponseEntity<String> {

        userRepository.save(customUser)

        return ResponseEntity.ok("User has succesfully been saved")
    }

}