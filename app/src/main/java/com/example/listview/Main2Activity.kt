package com.example.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val select = this.intent.getStringExtra("select")

        val textView = findViewById<TextView>(R.id.selectText)

        textView.text = getString(R.string.yourSelect,select)
    }
}
