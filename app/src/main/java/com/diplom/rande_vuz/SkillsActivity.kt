package com.diplom.rande_vuz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SkillsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val skillsInput = findViewById<EditText>(R.id.skills_input)

        nextBtn.setOnClickListener {
            val skills = skillsInput.text.toString().trim()

            if (skills.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                // Переход на следующий экран (например, AfterRegistrationActivity)
                startActivity(Intent(this, AfterRegistrationActivity::class.java))
            }
        }
    }
}
