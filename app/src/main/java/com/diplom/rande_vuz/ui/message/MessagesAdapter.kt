package com.diplom.rande_vuz.ui.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diplom.rande_vuz.databinding.ItemMessageBinding
import com.diplom.rande_vuz.ui.profile.UserProfile
import com.google.ai.client.generativeai.type.content

class MessagesAdapter : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {

    private val messages = mutableListOf<Message>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMessageBinding.inflate(inflater, parent, false)
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
        //holder.button.setOnclick
    }

    /*fun setupFilteredData(ids: ArrayList<UserProfile>){
        notifyItemRemoved()
    }*/

    override fun getItemCount(): Int = messages.size

    fun submitList(newMessages: List<Message>) {
        messages.clear()
        messages.addAll(newMessages)
        notifyDataSetChanged()
    }

    inner class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.textViewMessageContent.text = message.content

        }
    }
}
//добавить обработку медиа
