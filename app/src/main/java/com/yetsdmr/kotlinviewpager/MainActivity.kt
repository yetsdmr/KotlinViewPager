package com.yetsdmr.kotlinviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alphabets = listOf("a","b","c","d","e","f")
        val adapter = AlphabetPagerAdapter(alphabets)
        view_pager.adapter = adapter
    }
}