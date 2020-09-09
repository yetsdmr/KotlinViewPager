package com.yetsdmr.kotlinviewpager

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import java.util.*

class AlphabetPagerAdapter(private val list : List<String>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }

    override fun getCount(): Int {
       return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container?.context)
            .inflate(R.layout.page_layout,container,false)

        val linearLayout : LinearLayout = view.findViewById(R.id.linear_layout)
        val tvLower: TextView = view.findViewById(R.id.tv_lower)
        val tvLUpper: TextView = view.findViewById(R.id.tv_upper)
        val tvFooter: TextView = view.findViewById(R.id.tv_footer)

        tvLower.text = list[position]
        tvLUpper.text = list[position].toUpperCase()
        tvFooter.text = "Page ${position+1} of ${list.size}"

        tvLower.setTextColor(randomLightColor(70,80))
        tvLUpper.setTextColor(randomLightColor(90,70))


        linearLayout.setBackgroundColor(randomLightColor(10))

        container?.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    private fun randomLightColor(lightPercent:Int,blackPercent:Int=100):Int{
        // Color variance - red, green, blue etc
        val hue = Random().nextInt(361).toFloat()

        // Color light to dark - 0 light 100 dark
        val saturation = lightPercent.toFloat()/100F

        // Color black to bright - 0 black 100 bright
        val brightness:Float = blackPercent.toFloat()/100F

        // Transparency level, full opaque
        val alpha = 255

        // Return the color
        return Color.HSVToColor(alpha,floatArrayOf(hue,saturation,brightness))
    }
}