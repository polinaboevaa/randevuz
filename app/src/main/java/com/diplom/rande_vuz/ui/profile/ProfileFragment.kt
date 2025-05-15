package com.diplom.rande_vuz.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.diplom.rande_vuz.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        setupObservers()
        setupEditProfile()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.userProfile.observe(viewLifecycleOwner) { profile ->
            profile?.let {
                binding.textViewName.text = it.name
                binding.textViewAge.text = it.age.toString()
                binding.textViewUniversity.text = it.university
                binding.textViewCourse.text = it.course
                //binding.textViewSkills.text = it.skills
                binding.textViewAbout.text = it.about
                Glide.with(this).load(it.photoUrl).into(binding.imageViewProfile)
            }
        }
    }


    private fun setupEditProfile() {
        binding.buttonEditProfile.setOnClickListener {
            val intent = Intent(context, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}