package com.diplom.rande_vuz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SpecializationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specialization)

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val specializationInput = findViewById<EditText>(R.id.direction_input)

        nextBtn.setOnClickListener {
            val specialization = specializationInput.text.toString().trim()

            if (specialization.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, ExtracurricularActivity::class.java))
            }
        }
    }
}
