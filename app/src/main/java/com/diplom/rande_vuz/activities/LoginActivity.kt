package com.diplom.rande_vuz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.diplom.rande_vuz.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToRegisterActivityTv.setOnClickListener {
            startActivity(Intent(this, NameRegisterActivity::class.java))
        }

        binding.regbutton.setOnClickListener {
            val emailEt = binding.email.text.toString()
            val passwordEt = binding.password.text.toString()

            if (emailEt.isBlank() || passwordEt.isBlank()) {
                Toast.makeText(this, "Заполните все необходимые поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!emailEt.contains("@")) {
                Toast.makeText(this, "Некорректный почтовый адрес", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEt, passwordEt)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this@LoginActivity, AfterRegistrationActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "Ошибка входа: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }
}
