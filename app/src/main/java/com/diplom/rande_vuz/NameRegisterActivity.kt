package com.diplom.rande_vuz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.auth.FirebaseAuth
import java.util.zip.Inflater

class NameRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_register)

        val next_btn = findViewById<Button>(R.id.next_btn)
        val name_student = findViewById<EditText>(R.id.name_student)

        next_btn.setOnClickListener {
            val name = name_student.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, BirthDateActivity::class.java))
            }
        }

    }

}
