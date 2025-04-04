package com.diplom.rande_vuz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.diplom.rande_vuz.R
import com.diplom.rande_vuz.models.UserData

class ExtracurricularActivity : AppCompatActivity() {
    private lateinit var userData: UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extracurricular)

        userData = intent.getSerializableExtra("userData") as? UserData ?: UserData()

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val extracurricularInput = findViewById<EditText>(R.id.extracurricular_input)

        nextBtn.setOnClickListener {
            userData.extracurricular = extracurricularInput.text.toString().trim()

            Intent(this, WorkActivity::class.java).apply {
                putExtra("userData", userData)
                startActivity(this)
            }

        }
    }
}
