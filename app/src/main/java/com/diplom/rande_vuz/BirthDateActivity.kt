package com.diplom.rande_vuz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.view.View
import android.widget.Button
import java.util.Calendar

class BirthDateActivity : AppCompatActivity() {

    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var dateButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth_date)
        initDatePicker()
        dateButton = findViewById(R.id.datePickerButton)
        dateButton.text = getTodaysDate()
    }

    private fun getTodaysDate(): String {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1 // Месяцы начинаются с 0
        val day = cal.get(Calendar.DAY_OF_MONTH)
        return makeDateString(day, month, year)
    }

    private fun initDatePicker() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, day, month, year ->
            val adjustedMonth = month + 1 // Месяцы начинаются с 0
            val date = makeDateString(day, adjustedMonth, year)
            dateButton.text = date
        }

        val cal = Calendar.getInstance()
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH)
        val year = cal.get(Calendar.YEAR)

        val style = AlertDialog.THEME_HOLO_LIGHT

        datePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
        // datePickerDialog.datePicker.maxDate = System.currentTimeMillis() // Если нужно установить максимальную дату
    }

    private fun makeDateString(day: Int, month: Int, year: Int): String {
        return "${getMonthFormat(month)} $day, $year"
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
            else -> "JAN"
        }
    }

    fun openDatePicker(view: View) {
        datePickerDialog.show()
    }
}
