package com.coconutplace.wekit.ui.diary.decorators

import android.content.Context
import android.text.style.ForegroundColorSpan
import com.coconutplace.wekit.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import kotlin.collections.HashSet

class WrittenDayDecorator(context: Context?,  currentDay: CalendarDay): DayViewDecorator {
    private val color = context!!.getColor(R.color.diary_written_day)
    private val mDay = currentDay

    override fun shouldDecorate(day: CalendarDay): Boolean {
        return day == mDay
    }

    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(object: ForegroundColorSpan(color){})
    }
}