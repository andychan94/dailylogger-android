package jp.xearts.daylogger

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent


/**
 * Created by nodir on 2017/12/13.
 */
class CustomViewPager : ViewPager {
    private var swipeable: Boolean = false


    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.swipeable = true
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.swipeable) {
            super.onTouchEvent(event)
        } else false
    }

    override fun performClick(): Boolean {
        return super.performClick()
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (this.swipeable) {
            super.onInterceptTouchEvent(event)
        } else false
    }

    fun setSwipeable(swipeable: Boolean) {
        this.swipeable = swipeable

    }

}