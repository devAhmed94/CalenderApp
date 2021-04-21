package com.example.calenderapp

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.example.calenderapp.databinding.ActivityMainBinding
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import com.kizitonwose.calendarview.ui.ViewContainer


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 20/04/2021
 */
class MyMonthHeaderFooterBinder: MonthHeaderFooterBinder<MyMonthHeaderFooterBinder.MonthViewContainer> {
    override fun create(view: View) = MonthViewContainer(view)
    override fun bind(container: MonthViewContainer, month: CalendarMonth) {

    }
    class MonthViewContainer(view: View) : ViewContainer(view) {

    }
}


