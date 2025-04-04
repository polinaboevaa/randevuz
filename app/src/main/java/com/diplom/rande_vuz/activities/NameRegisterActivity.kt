package com.diplom.rande_vuz.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.diplom.rande_vuz.R
import com.diplom.rande_vuz.models.UserData

class NameRegisterActivity : AppCompatActivity() {
    private lateinit var userData: UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_register)

        userData = intent.getSerializableExtra("userData") as? UserData ?: UserData()

        val next_btn = findViewById<Button>(R.id.next_btn)
        val name_student = findViewById<EditText>(R.id.name_student)

        next_btn.setOnClickListener {
            userData.name = name_student.text.toString().trim()

            if (userData.name.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                Intent(this, BirthDateActivity::class.java).apply {
                    putExtra("userData", userData)
                    startActivity(this)
                }
            }
        }

    }

}
