package com.shell.android.mybaseapplication

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.shell.android.mybaselibrary.ui.MenuButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupOnclick()
    }

    private fun setupOnclick() {
        btnMenu.listener = object : MenuButton.OnMainButtonClickListener {
            override fun onClick() {
                Snackbar.make(conMain, "${btnMenu.getText()} clicked!", Snackbar.LENGTH_LONG)
                    .show()
            }
        }

        btnEnable.setOnClickListener {
            btnMenu.isEnabled = true
        }
        btnDisable.setOnClickListener {
            btnMenu.isEnabled = false
        }
    }
}
