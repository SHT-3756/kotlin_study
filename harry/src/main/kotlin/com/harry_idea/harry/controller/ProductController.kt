package com.harry_idea.harry.controller

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.gson.Gson
import com.harry_idea.harry.dto.CustomResponseDto
import com.harry_idea.harry.dto.ProductDetailDto
import com.harry_idea.harry.dto.ProductDto
import com.harry_idea.harry.service.ProductService
import com.harry_idea.harry.utils.CustomUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: ProductService) {
    // 프로젝트 리스트 불러오기
    @GetMapping("/v1/products")
    fun getProducts(): ResponseEntity<List<ProductDto>> {
        val result = productService.getProducts()

        return ResponseEntity.ok().body(result)
    }

    // 조회 조건 (내가 원하는 필드의 값을 비교해서 동일한 데이터를 조회한다.)
    @GetMapping("/v1/products/{fieldKey}/{fieldValue}")
    fun getFindProducts(
        @PathVariable fieldKey: String,
        @PathVariable fieldValue: String,
    ): ResponseEntity<CustomResponseDto> {
        val result = productService.getFindProduct(fieldKey, fieldValue)

        return ResponseEntity.ok().body(result)
    }

    // product 생성
    @PostMapping("/v1/product")
    fun createProduct(@RequestBody productDto: ProductDto): ResponseEntity<Boolean> {
        val result = productService.createProduct(productDto)
        return ResponseEntity.ok().body(true)
    }

    // product 삭제
    @DeleteMapping("/v1/product/{productId}")
    fun deleteProduct(@PathVariable productId: String): ResponseEntity<CustomResponseDto> {
        val result = productService.deleteProduct(productId)
        return ResponseEntity(result, result.code)
    }

    // product 수정
    @PutMapping("/v1/product/{productId}")
    fun updateProduct(
        @PathVariable productId: String,
        @RequestBody productDto: ProductDto
    ): ResponseEntity<CustomResponseDto> {
        val result = productService.updateProduct(productId, productDto)
        return ResponseEntity(result, result.code)
    }

}