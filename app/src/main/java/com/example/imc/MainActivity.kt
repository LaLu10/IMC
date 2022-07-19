package com.example.imc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.example.imc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var height=150
    private var weight=75
    private var doubleHeight=2.25
    private var IMC=33.33
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.sbAltura.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvContAlt.text = seek?.progress.toString().plus("/200")
                height=progress
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) { calcIMC()
            }
        })
        b.sbPeso.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvContPeso.text = seek?.progress.toString().plus("/150")
                weight=progress

            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) { calcIMC()
            }
        })

    }
    fun calcIMC(){
        doubleHeight=height.times(height)/10000.0
        IMC=Math.round((weight/doubleHeight).times(100)).div(100.0)
        b.textView5.text=IMC.toString()
//        calcObesidad()
    }
//    fun calcObesidad(){
//        if ()
//    }
}

