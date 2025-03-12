package com.diplom.rande_vuz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val descriptionInput = findViewById<EditText>(R.id.description_input)

        nextBtn.setOnClickListener {
            val description = descriptionInput.text.toString().trim()

            if (description.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                // Переход на следующий экран (например, AfterRegistrationActivity)
                startActivity(Intent(this, AfterRegistrationActivity::class.java))
            }
        }
    }
}
