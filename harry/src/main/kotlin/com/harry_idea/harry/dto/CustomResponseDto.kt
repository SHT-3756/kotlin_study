package com.harry_idea.harry.dto

import org.springframework.http.HttpStatus

class CustomResponseDto {
    lateinit var code: HttpStatus
    lateinit var message: String
    lateinit var data: Any
}