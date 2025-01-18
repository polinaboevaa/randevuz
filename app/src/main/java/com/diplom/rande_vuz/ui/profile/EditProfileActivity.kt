package com.diplom.rande_vuz.ui.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diplom.rande_vuz.databinding.ActivityEditProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadCurrentProfile()
        setupSaveButton()
    }

    private fun loadCurrentProfile() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
        FirebaseFirestore.getInstance().collection("users")
            .document(userId)
            .get()
            .addOnSuccessListener { document ->
                val profile = document.toObject(UserProfile::class.java)
                profile?.let {
                    binding.editTextName.setText(it.name)
                    binding.editTextAge.setText(it.age.toString())
                    binding.editTextUniversity.setText(it.university)
                    binding.editTextCourse.setText(it.course)
                    binding.editTextSkills.setText(it.skills)
                    binding.editTextAbout.setText(it.about)
                }
            }
    }

    private fun setupSaveButton() {
        binding.buttonSave.setOnClickListener {
            val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return@setOnClickListener

            val updatedProfile = UserProfile(
                name = binding.editTextName.text.toString(),
                age = binding.editTextAge.text.toString().toIntOrNull() ?: 0,
                university = binding.editTextUniversity.text.toString(),
                course = binding.editTextCourse.text.toString(),
                skills = binding.editTextSkills.text.toString(),
                about = binding.editTextAbout.text.toString(),
                photoUrl = null // добавить логику загрузки фото
            )

            FirebaseFirestore.getInstance().collection("users")
                .document(userId)
                .set(updatedProfile)
                .addOnSuccessListener {
                    Toast.makeText(this, "Профиль обновлен!", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Не удалось обновить профиль", Toast.LENGTH_SHORT).show()
                }
        }
    }
}