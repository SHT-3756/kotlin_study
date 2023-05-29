package com.harry_idea.harry.service

import com.google.cloud.firestore.*
import com.google.firebase.cloud.FirestoreClient
import com.harry_idea.harry.dto.CustomResponseDto
import com.harry_idea.harry.dto.ProductDetailDto
import com.harry_idea.harry.dto.ProductDto
import com.harry_idea.harry.utils.CustomUtils
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.Objects


@Service
class ProductServiceImpl(var fireStoreService: FireStoreService) : ProductService {

    override fun getProducts(): List<ProductDto> {
        val result = mutableListOf<ProductDto>()
        var db: Firestore = FirestoreClient.getFirestore()
        val collection = db.collection("product").get()
        val documents = collection.get().documents

        for (document in documents) {
            result.add(document.toObject(ProductDto::class.java))
        }

        return result
    }

    override fun createProduct(productDto: ProductDto): Boolean {
        val db: Firestore = FirestoreClient.getFirestore()
        val collection = db.collection("product")
        val docRef: DocumentReference = db.collection("product").document()
        var returnResult = false

        CustomUtils().customPrint(docRef)

        try {
            val result = collection.document().set(productDto, SetOptions.merge())
            CustomUtils().customPrint(result)

            returnResult = true
        } catch (e: Exception) {
            returnResult = false
        }

        CustomUtils().customPrint(returnResult)
        return returnResult
    }

    override fun deleteProduct(productId: String): CustomResponseDto {
        var res = CustomResponseDto()

        try {
            var documentSnapshot: DocumentSnapshot? = fireStoreService.getDocument("product", productId)

            if (documentSnapshot != null) {
                if (documentSnapshot.exists()) {
                    if (documentSnapshot.reference.listCollections().count() > 0) {
                        throw Exception("하위 컬렉션이 존재하여 삭제가 불가능합니다.")
                    }
                }
            }

            var result: String? = fireStoreService.deleteDocument("product", productId)
            if (result != null) {
                res.message = ""
                res.code = HttpStatus.OK
                res.data = true

                return res
            }
            res.message = ""
            res.code = HttpStatus.OK
            res.data = false

            return res
        } catch (e: Exception) {
            res.message = e.localizedMessage
            res.code = HttpStatus.OK
            res.data = false

            return res
        }
    }

    override fun updateProduct(productId: String, productDto: ProductDto): CustomResponseDto {
        var res = CustomResponseDto()

        try {
            val data = mapOf(
                "advertiseId" to productDto.advertiseId,
                "test_product_list" to productDto.test_product_list,
            )

            val db: Firestore = FirestoreClient.getFirestore()

            var result = db.collection("product").document(productId).update(data)

            CustomUtils().customPrint(productId)
            CustomUtils().customPrint(data)
            CustomUtils().customPrint(result)

            res.message = ""
            res.code = HttpStatus.OK
            res.data = data
            return res
        } catch (e: Exception) {

            res.message = e.localizedMessage
            res.code = HttpStatus.OK
            res.data = false

            return res
        }
    }

    override fun getFindProduct(fieldKey: String, fieldValue: String): CustomResponseDto {
        print(fieldValue)
        var res = CustomResponseDto()
        var productDtos = mutableListOf<ProductDto>()

        try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection("product").whereEqualTo(fieldKey, fieldValue).get()


            val documents = future.get().documents

            if(documents != null) {
                for(document in documents) {
                    productDtos.add(document.toObject(ProductDto::class.java))
                }

                res.message = "Success"
                res.code = HttpStatus.OK
                res.data = productDtos
            } else {
                res.message = "Success : 찾는 값이 없습니다."
                res.code = HttpStatus.OK
                res.data = productDtos
            }

            return res
        }catch (e:Exception) {
            print(e.localizedMessage)
            res.message = "Success : 찾는 값이 없습니다."
            res.code = HttpStatus.OK
            res.data = false

            return res
        }
    }
}





























