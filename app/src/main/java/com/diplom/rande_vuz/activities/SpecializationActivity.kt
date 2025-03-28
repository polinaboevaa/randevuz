package com.diplom.rande_vuz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.diplom.rande_vuz.R
import com.diplom.rande_vuz.models.UserData

class SpecializationActivity : AppCompatActivity() {
    private lateinit var userData: UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specialization)

        userData = intent.getSerializableExtra("userData") as? UserData ?: UserData()

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val specializationInput = findViewById<EditText>(R.id.direction_input)

        nextBtn.setOnClickListener {
            userData.specialization = specializationInput.text.toString().trim()

            if (userData.specialization.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                Intent(this, SkillsActivity::class.java).apply {
                    putExtra("userData", userData)
                    startActivity(this)
                }
            }
        }
    }
}
