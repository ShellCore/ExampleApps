package com.shell.android.mybaselibrary.ui

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import com.shell.android.mybaselibrary.R

class NavButton(context: Context) : LinearLayout(context) {

    lateinit var listener: OnNavButtonClickLister

    private lateinit var button: Button

    var mSelected : Boolean = false
    var mText : String = "0"

    interface OnNavButtonClickLister {
        fun onClick()
    }

    init {
        setupView()
    }

    private fun setupView() {
        orientation = VERTICAL
        addView(addButton())
    }

    private fun addButton() : Button {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        button = inflater.inflate(R.layout.nav_button, this, false) as Button
        button.apply {
            text = mText
            setOnClickListener { listener.onClick() }
        }
        return button
    }

    fun setText(text: String) {
        mText = text
        button.text = mText
    }

    fun setButtonSelected(selected: Boolean) {
        mSelected = selected
        button.isSelected = selected
    }
}