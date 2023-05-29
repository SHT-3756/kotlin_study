package com.harry_idea.harry.service

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.harry_idea.harry.dto.CustomResponseDto
import com.harry_idea.harry.dto.ProductDetailDto
import com.harry_idea.harry.dto.ProductDto

interface ProductService {
    // 읽기 (리스트)
    fun getProducts(): List<ProductDto>
    // 읽기 (디테일)

    // 생성
    fun createProduct(productDto: ProductDto): Boolean

    // 삭제
    fun deleteProduct(productId: String): CustomResponseDto

    // 수정
    fun updateProduct(productId: String, productDto: ProductDto): CustomResponseDto

    // 읽기 (내가 원하는 필드값의 value 를 찾기)
    fun getFindProduct(fieldKey: String, fieldValue: String) : CustomResponseDto
}