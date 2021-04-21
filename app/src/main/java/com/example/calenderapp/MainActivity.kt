package com.example.calenderapp

import android.graphics.Color


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calenderapp.databinding.ActivityMainBinding
import java.time.YearMonth
import java.time.temporal.TemporalAdjusters
import java.time.temporal.WeekFields
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentMonth = YearMonth.now()
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        drawDaysStyle()
        drawHeader()
        binding.calendarView.setup(currentMonth, currentMonth, firstDayOfWeek)
        binding.calendarView.scrollToMonth(currentMonth)
    }

    private fun drawHeader() {
        binding.calendarView.monthHeaderBinder = MyMonthHeaderFooterBinder()
    }

    private fun drawDaysStyle() {
        binding.calendarView.dayBinder = MydayBinder()

    }


}