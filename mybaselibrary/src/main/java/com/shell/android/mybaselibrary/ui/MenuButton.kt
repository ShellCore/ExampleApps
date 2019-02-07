package com.shell.android.mybaselibrary.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.shell.android.mybaselibrary.R
import de.hdodenhof.circleimageview.CircleImageView

class MenuButton(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    lateinit var listener: OnMainButtonClickListener

    private lateinit var circleImageView: CircleImageView

    private var mEnabled: Boolean = true
    private var mVisible: Int = View.GONE
    private var mSrc: Int? = 0
    private var mText: String? = ""

    interface OnMainButtonClickListener {
        fun onClick()
    }

    init {
        val attrArray = context.obtainStyledAttributes(attrs, R.styleable.MenuButton)

        mEnabled = attrArray.getBoolean(R.styleable.MenuButton_enabled, true)
        mVisible = attrArray.getInt(R.styleable.MenuButton_visible, View.VISIBLE)
        mSrc = attrArray.getResourceId(R.styleable.MenuButton_src, R.drawable.ic_default)
        mText = attrArray.getString(R.styleable.MenuButton_text)

        setupView()

        attrArray.recycle()
    }

    override fun setEnabled(enabled: Boolean) {
        mEnabled = enabled
        circleImageView.isEnabled = enabled
    }

    fun getText(): String {
        return mText!!
    }

    override fun setVisibility(visibility: Int) {
        mVisible = visibility
    }

    private fun setupView() {
        orientation = LinearLayout.VERTICAL

        addView(getButtonView())
        addView(getTextDescription())
    }

    private fun getButtonView(): CircleImageView {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        circleImageView = inflater.inflate(R.layout.menu_button, this, false) as CircleImageView
        circleImageView.apply {
            setImageResource(mSrc!!)
            setOnClickListener { listener.onClick() }
        }
        return circleImageView
    }

    private fun getTextDescription(): TextView {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val textView = inflater.inflate(R.layout.menu_button_description, this, false) as TextView
        textView.apply {
            text = mText

        }
        return textView
    }
}