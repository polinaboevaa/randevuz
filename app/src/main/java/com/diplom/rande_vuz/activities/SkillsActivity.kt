package com.diplom.rande_vuz.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diplom.rande_vuz.R
import com.diplom.rande_vuz.models.UserData

class SkillsActivity : AppCompatActivity() {
    private lateinit var userData: UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skills)

        userData = intent.getSerializableExtra("userData") as? UserData ?: UserData()

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val skillsInput = findViewById<EditText>(R.id.skills_input)

        nextBtn.setOnClickListener {
            userData.skills = skillsInput.text.toString().trim()
            Intent(this, ExtracurricularActivity::class.java).apply {
                putExtra("userData", userData)
                startActivity(this)
            }
        }
    }
}
