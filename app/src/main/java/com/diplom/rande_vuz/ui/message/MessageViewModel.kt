package com.diplom.rande_vuz.ui.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.diplom.rande_vuz.ui.message.Message
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID

class MessageViewModel : ViewModel() {

    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages

    private val _sendStatus = MutableLiveData<SendStatus>()
    val sendStatus: LiveData<SendStatus> = _sendStatus

    fun sendMessage(content: String) {
        val message = Message(
            id = UUID.randomUUID().toString(),
            content = content,
            timestamp = System.currentTimeMillis(),
            senderId = FirebaseAuth.getInstance().currentUser?.uid ?: "",
            read = false
        )
        FirebaseFirestore.getInstance().collection("messages")
            .add(message)
            .addOnSuccessListener {
                _sendStatus.value = SendStatus.Success
            }
            .addOnFailureListener {
                _sendStatus.value = SendStatus.Error(it)
            }
    }

    fun loadMessages() {
        // загрузка сообщений из Firebase
        FirebaseFirestore.getInstance().collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    return@addSnapshotListener
                }
                if (snapshot != null && !snapshot.isEmpty) {
                    val messagesList = snapshot.toObjects(Message::class.java)
                    _messages.value = messagesList
                }
            }
    }
}