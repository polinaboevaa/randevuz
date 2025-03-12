package com.diplom.rande_vuz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class WorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val workInput = findViewById<EditText>(R.id.work_input)

        nextBtn.setOnClickListener {
            val workPlace = workInput.text.toString().trim()

            if (workPlace.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                // Переход на следующий экран (например, AfterRegistrationActivity)
                startActivity(Intent(this, AfterRegistrationActivity::class.java))
            }
        }
    }
}
