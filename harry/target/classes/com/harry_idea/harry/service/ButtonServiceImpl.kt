package com.harry_idea.harry.service

import com.google.firebase.cloud.FirestoreClient
import com.harry_idea.harry.dto.ButtonDto
import com.harry_idea.harry.dto.CustomResponseDto
import com.harry_idea.harry.utils.CustomUtils
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class ButtonServiceImpl : ButtonService {


    override fun getButtons(): CustomResponseDto {
        var res = CustomResponseDto()
        try {

            val result = mutableListOf<ButtonDto>()
            var db = FirestoreClient.getFirestore()
            val collection = db.collection("product_button").get()
            CustomUtils().customPrint(collection)
            val documents = collection.get().documents

            for(doc in documents) {
                CustomUtils().customPrint(doc)
                CustomUtils().customPrint(documents)
                result.add(doc.toObject(ButtonDto::class.java))
            }

            res.message = ""
            res.code = HttpStatus.OK
            res.data = result

            return res
        }catch (e: Exception) {
            res.message = e.localizedMessage
            res.code = HttpStatus.OK
            res.data = false

            return res
        }
    }
}