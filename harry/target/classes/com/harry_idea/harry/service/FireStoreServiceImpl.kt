package com.harry_idea.harry.service

import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class FireStoreServiceImpl : FireStoreService {
    override fun getDocuments(collection: String): List<QueryDocumentSnapshot>? {
        return try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).get()

            future.get().documents
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    override fun getDocument(collection: String, document: String): DocumentSnapshot? {
        return try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).document(document).get()

            future.get()
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    override fun deleteDocument(collection: String, document: String): String? {
        return try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).document(document).delete()

            future.get().updateTime.toString()
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

    override fun updateDocument(collection: String, document: String, data: Map<String, Any?>): String? {
        return try {
            val db: Firestore = FirestoreClient.getFirestore()
            val future = db.collection(collection).document(document).update(data)

            future.get().updateTime.toString()
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

}