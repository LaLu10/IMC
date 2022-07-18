package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.imc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b= ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        val seekBarPeso=b.sbPeso
        val seekBarAltura=b.sbAltura
        var peso = seekBarPeso.getProgress().toDouble()
        var altura=seekBarAltura.getProgress().toDouble()
        b.sbAltura.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvContAlt.text= seek?.progress.toString().plus("/200")
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
            })
        b.sbPeso.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvContPeso.text= seek?.progress.toString().plus("/150")

            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

    })
    }
}

