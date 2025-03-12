package com.diplom.rande_vuz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class GoalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        val nextBtn = findViewById<MaterialButton>(R.id.next_btn)
        val goalWork = findViewById<MaterialButton>(R.id.goal_work)
        val goalFriendship = findViewById<MaterialButton>(R.id.goal_friendship)
        val goalTutoring = findViewById<MaterialButton>(R.id.goal_tutoring)
        val goalUnknown = findViewById<MaterialButton>(R.id.goal_unknown)

        val goals = listOf(goalWork, goalFriendship, goalTutoring)

        // Логика выбора: при клике меняем цвет
        fun toggleButton(button: MaterialButton) {
            val isSelected = button.tag as? Boolean ?: false
            if (isSelected) {
                button.setBackgroundColor(resources.getColor(R.color.pink)) // Возвращаем в обычное состояние
                button.tag = false
            } else {
                button.setBackgroundColor(resources.getColor(R.color.blue)) // Выбираем
                button.tag = true
            }
        }

        // Устанавливаем обработчики на кнопки
        goals.forEach { button ->
            button.setOnClickListener {
                goalUnknown.setBackgroundColor(resources.getColor(R.color.pink)) // Сбрасываем "Не знаю"
                goalUnknown.tag = false
                toggleButton(button)
            }
        }

        goalUnknown.setOnClickListener {
            // Сбрасываем все остальные
            goals.forEach { button ->
                button.setBackgroundColor(resources.getColor(R.color.pink))
                button.tag = false
            }
            goalUnknown.setBackgroundColor(resources.getColor(R.color.strong_pink)) // Делаем активной
            goalUnknown.tag = true
        }

        nextBtn.setOnClickListener {
            val isAnySelected = goals.any { it.tag == true } || goalUnknown.tag == true
            if (!isAnySelected) {
                Toast.makeText(this, "Выберите хотя бы одну цель", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, AfterRegistrationActivity::class.java))
            }
        }
    }
}
