package kz.porcuon.movien.flow.home

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class HomeViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    var isSwipePageChangeEnabled = false

    override fun onTouchEvent(ev: MotionEvent?) = false

    override fun onInterceptTouchEvent(ev: MotionEvent?) = isSwipePageChangeEnabled && super.onTouchEvent(ev)

    override fun setCurrentItem(item: Int, smoothScroll: Boolean) {
        super.setCurrentItem(item, isSwipePageChangeEnabled)
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, isSwipePageChangeEnabled)
    }
}