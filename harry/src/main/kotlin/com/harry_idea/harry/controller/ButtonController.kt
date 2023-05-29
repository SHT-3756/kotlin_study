package com.harry_idea.harry.controller

import com.harry_idea.harry.dto.CustomResponseDto
import com.harry_idea.harry.service.ButtonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ButtonController(val buttonService: ButtonService) {

    @GetMapping("/v1/buttons")
    fun getButtons() : ResponseEntity<CustomResponseDto> {
        val result = buttonService.getButtons()

        return ResponseEntity.ok().body(result)
    }

}