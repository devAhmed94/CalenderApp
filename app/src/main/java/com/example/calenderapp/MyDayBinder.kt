package com.example.calenderapp

import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 20/04/2021
 */
class MyDayBinder : DayBinder<MyDayBinder.DayViewContainer> {
    private val START_DAY = 13
    private val END_DAY = 28
    var selected = false
    lateinit var container: DayViewContainer
    lateinit var day: CalendarDay
    lateinit var view: View
    override fun create(view: View): DayViewContainer {
        this.view = view
        /* view.setOnClickListener {

         }*/
        return DayViewContainer(view)
    }

    override fun bind(container: DayViewContainer, day: CalendarDay) {
        container.textView.text = day.date.dayOfMonth.toString()

        container.textView.setOnClickListener {
            selected = true
            bind(container, day)
        }

        checkConditions(container, day)
        selectedStyle(container.textView)

    }


    private fun checkConditions(container: DayViewContainer, day: CalendarDay) {
        this.container = container
        this.day = day
        if (day.owner == DayOwner.THIS_MONTH) {
            container.textView.visibility = View.VISIBLE
            when (day.date) {
                LocalDate.of(LocalDate.now().year, LocalDate.now().month, START_DAY) -> {
                    container.textView.apply {
                        setBackgroundResource(R.drawable.bg_cell_start)
                        setTextColor(Color.WHITE)
                        isClickable = false
                    }
                }
                LocalDate.of(LocalDate.now().year, LocalDate.now().month, END_DAY) -> {
                    container.textView.apply {
                        setBackgroundResource(R.drawable.bg_cell_end)
                        isClickable = false
                    }
                }

                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    1
                ).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    8
                ).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    15
                ).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }

                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    22
                ).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    29
                ).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    1
                ).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    8
                ).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    15
                ).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }

                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    22
                ).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    29
                ).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)) -> {
                    container.textView.apply {
                        setTextColor(Color.parseColor("#EDEDED"))
                        isClickable = false
                    }
                }
                LocalDate.now() -> {
                    container.textView.apply {
                        setBackgroundResource(R.drawable.bg_today)
                    }
                }
                in LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    START_DAY
                )..LocalDate.now() -> {
                    container.textView.apply {
                        setBackgroundResource(R.drawable.bg_cell_unselected)
                        isClickable = false
                    }
                }
                in LocalDate.now()..LocalDate.of(
                    LocalDate.now().year,
                    LocalDate.now().month,
                    END_DAY
                ) -> {
                    container.textView.apply {
                        setBackgroundResource(R.drawable.bg_cell_selected)

                    }
                }
                else -> {
                    container.textView.apply {
                        setBackgroundColor(Color.TRANSPARENT)

                    }
                }

            }

        } else {
            container.textView.apply {
                visibility = View.INVISIBLE
            }

        }

    }

    private fun selectedStyle(textView: AppCompatTextView) {
        if (selected) {
            Log.d("TAG", "selectedStyle: selected true ")
            textView.setBackgroundResource(R.drawable.bg_cell_select_now)
            textView.setTextColor(Color.WHITE)
        }

        if (!selected) {
            Log.d("TAG", "selectedStyle: selected false ")
        }
        selected = false
    }


    private fun clearView(container: DayViewContainer, day: CalendarDay) {
        if (day.owner == DayOwner.THIS_MONTH) {
            container.textView.visibility = View.VISIBLE
            container.textView.apply {
                setBackgroundColor(Color.TRANSPARENT)
                setTextColor(Color.BLACK)
            }


        } else {
            container.textView.visibility = View.INVISIBLE
        }
    }


    inner class DayViewContainer(view: View) : ViewContainer(view) {
        val textView: AppCompatTextView = view.findViewById<AppCompatTextView>(R.id.calendarDayText)

        init {
            textView.apply {
                setBackgroundColor(Color.TRANSPARENT)
                setTextColor(Color.BLACK)
            }
        }

    }
}

