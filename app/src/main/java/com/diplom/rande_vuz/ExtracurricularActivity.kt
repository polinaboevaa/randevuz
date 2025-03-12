package com.diplom.rande_vuz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ExtracurricularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extracurricular)

        val nextBtn = findViewById<Button>(R.id.next_btn)
        val extracurricularInput = findViewById<EditText>(R.id.extracurricular_input)

        nextBtn.setOnClickListener {
            val activity = extracurricularInput.text.toString().trim()

            if (activity.isEmpty()) {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, WorkActivity::class.java))
            }
        }
    }
}
