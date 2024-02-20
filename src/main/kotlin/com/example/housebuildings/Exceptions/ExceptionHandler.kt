package com.example.housebuildings.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import jakarta.validation.ConstraintViolationException


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NoSuchElementException::class)
    fun notFoundException(exception: NoSuchElementException): ResponseEntity<*> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(exception.message)
    }

    @ExceptionHandler(NullPointerException::class)
    fun nullPointerException(exception: NullPointerException): ResponseEntity<*> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(exception.message)
    }

    @ExceptionHandler(RuntimeException::class)
    fun propertyNameException(exception: RuntimeException): ResponseEntity<*> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.message)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun argumentNotValid(exception: MethodArgumentNotValidException): ResponseEntity<*> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(exception.message)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun invalidFieldFormat(exception: ConstraintViolationException): ResponseEntity<*> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(exception.message)
    }
}