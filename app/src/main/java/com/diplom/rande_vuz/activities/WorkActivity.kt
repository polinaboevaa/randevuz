package com.diplom.rande_vuz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.diplom.rande_vuz.R
import com.diplom.rande_vuz.models.UserData

class WorkActivity : AppCompatActivity() {
    private lateinit var userData: UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        userData = intent.getSerializableExtra("userData") as? UserData ?: UserData()

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val workInput = findViewById<EditText>(R.id.work_input)

        nextBtn.setOnClickListener {
            userData.work = workInput.text.toString().trim()

            Intent(this, GoalActivity::class.java).apply {
                putExtra("userData", userData)
                startActivity(this)
            }

        }
    }
}
