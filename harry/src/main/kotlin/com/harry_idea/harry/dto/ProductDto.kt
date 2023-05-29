package com.harry_idea.harry.dto

// product 전체
class ProductDto {
    var advertiseId: String = ""
    var test_product_list: List<ProductDetailDto>? = null
}

// test_product_list
class ProductDetailDto {
    var content: String = ""
    var id: String = ""
    var image_url: String = ""
    var title: String = ""
}