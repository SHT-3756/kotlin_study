package com.harry_idea.harry.service

import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.QueryDocumentSnapshot

interface FireStoreService {
    fun getDocuments(collection: String): List<QueryDocumentSnapshot>?

    fun getDocument(collection: String, document: String): DocumentSnapshot?

    fun deleteDocument(collection: String, document: String): String?

    fun updateDocument(collection: String, document: String, data: Map<String, Any?>): String?

}