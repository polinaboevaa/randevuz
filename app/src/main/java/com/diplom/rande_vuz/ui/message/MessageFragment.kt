package com.diplom.rande_vuz.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.adapters.ViewBindingAdapter.setOnClick
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.diplom.rande_vuz.databinding.FragmentMessageBinding


class MessageFragment : Fragment() {

    private lateinit var viewModel: MessageViewModel
    private lateinit var binding: FragmentMessageBinding
    private lateinit var messagesAdapter: MessagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MessageViewModel::class.java)

        setupRecyclerView()
        setupObservers()
        setupSendMessage()
        /*setOnClick{
            messagesAdapter.setupFilteredData()
        }*/

        return binding.root
    }

    private fun setupRecyclerView() {
        messagesAdapter = MessagesAdapter()
        binding.recyclerViewMessages.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = messagesAdapter
        }
    }

    private fun setupObservers() {
        viewModel.messages.observe(viewLifecycleOwner) { messages ->
            messagesAdapter.submitList(messages)
        }

        viewModel.sendStatus.observe(viewLifecycleOwner) { status ->
            when (status) {
                is SendStatus.Success -> {
                    binding.editTextMessage.text.clear()
                }
                is SendStatus.Error -> {
                    Toast.makeText(context, "Ошибка отправки сообщения", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    //необработанный статус
                }
            }
        }
    }

    private fun setupSendMessage() {
        binding.buttonSend.setOnClickListener {
            val messageText = binding.editTextMessage.text.toString()
            if (messageText.isNotBlank()) {
                viewModel.sendMessage(messageText)
            }
        }

        binding.buttonAttach.setOnClickListener {
            // Логика выбора и отправки фото
            selectImageFromGallery()
        }
    }

    private fun selectImageFromGallery() {
        // Код для выбора изображения из галереи
    }
}