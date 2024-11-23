package com.diplom.rande_vuz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.content.Intent // Импортируем Intent
import java.util.Calendar

class BirthDateActivity : AppCompatActivity() {

    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var dateButton: Button
    private lateinit var nextButton: Button // Объявляем переменную для кнопки "next"
    private var selectedDate: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth_date)

        dateButton = findViewById(R.id.datePickerButton)
        val nextButton = findViewById<Button>(R.id.next_btn)
        initDatePicker()

        nextButton.setOnClickListener {
            if (selectedDate != null) {
                val intent = Intent(this, WhereStudyActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Дата не выбрана", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initDatePicker() {
        val cal = Calendar.getInstance()
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)

        datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val adjustedMonth = selectedMonth + 1
            selectedDate = makeDateString(selectedDay, adjustedMonth, selectedYear)
            dateButton.text = selectedDate
        }, year, month, day)
    }

    private fun makeDateString(day: Int, month: Int, year: Int): String {
        return "$day/${getMonthFormat(month)}/$year"
    }

    private fun getMonthFormat(month: Int): String {
        return when (month) {
            1 -> "январь"
            2 -> "февраль"
            3 -> "март"
            4 -> "апрель"
            5 -> "май"
            6 -> "июнь"
            7 -> "июль"
            8 -> "август"
            9 -> "сентябрь"
            10 -> "октябрь"
            11 -> "ноябрь"
            12 -> "декабрь"
            else -> "январь"
        }
    }

    fun openDatePicker(view: View) {
        datePickerDialog.show()
    }
}
