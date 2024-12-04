package com.krillinator.lektion_7_consume_api_fetch_cors_backend.handlers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

// Global Exception Handling
@ControllerAdvice
class ValidationExceptionHandler {

    // If this exception happens: Run this function INSTEAD
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<List<String?>> {
        val errors = ex.bindingResult.allErrors.map { index ->
            if (index is FieldError) {
                "${index.field}: ${index.defaultMessage}"
            } else {
                index.defaultMessage
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }

}