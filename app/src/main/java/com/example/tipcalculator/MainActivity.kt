package com.example.tipcalculator

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var seekbar = findViewById<SeekBar>(R.id.seekBar)
        var textseekbar = findViewById<TextView>(R.id.seekbartext)
        var tipamount = findViewById<TextView>(R.id.tipamount)
        var netamount = findViewById<TextView>(R.id.netamount)
        var baseamountinput = findViewById<EditText>(R.id.baseamountinput)


        fun changeoutput(){
            if(baseamountinput.text.toString().isEmpty()){
                tipamount.text="0"
                netamount.text="0"
            }
            else{
                val cbaseamount = baseamountinput.text.toString().toFloat()
                val ctipamount:Float= seekbar.progress.toFloat() * cbaseamount /100
                tipamount.text = ctipamount.toString()
                netamount.text = (ctipamount+cbaseamount).toString()
            }
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textseekbar.text=progress.toString()
                changeoutput()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        baseamountinput.addTextChangedListener(){
            changeoutput()
        }

    }
}
