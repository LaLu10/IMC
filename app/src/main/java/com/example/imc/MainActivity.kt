package com.example.imc

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog
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
        b.imageView.setOnClickListener {
            val inflater= this!!.layoutInflater
            val customlayout= inflater.inflate(R.layout.tabla_imc,null)
            AlertDialog.Builder(this!!).setView(customlayout) .setNegativeButton("Aceptar", { dialog, id -> }).show().show()
        }

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
        calcObesidad()
    }
    @SuppressLint("ResourceType")
    fun calcObesidad(){
        var msj= when(IMC){
           in 0.0..16.00 ->  Snackbar.make(b.root, "Delgadez Severa", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.lila)).show()
           in 16.00..16.99 ->Snackbar.make(b.root, "Delgadez Moderada", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.azulclaro)).show()

           in 17.00..18.49 ->Snackbar.make(b.root, "Delgadez Leve", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.azul)).show()

           in 18.50..24.99 ->Snackbar.make(b.root, "Peso Normal", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.verde)).show()

           in 25.00..29.99 ->Snackbar.make(b.root, "PreObesidad", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.verdefeo)).show()

           in 30.00..34.99 ->Snackbar.make(b.root, "Obesidad Leve", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.naranja))
               .setAction("VER TABLA") {
                   showTable()
                   val inflater = this!!.layoutInflater
                   val customlayout = inflater.inflate(R.layout.tabla_imc, null)
                   AlertDialog.Builder(this!!).setView(customlayout)
                       .setNegativeButton("Aceptar", { dialog, id -> }).show()
               }.show()
               in 35.00..40.00 ->Snackbar.make(b.root, "Obesidad Media", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.naranja2)).show()

               in 40.01..100000.0 ->Snackbar.make(b.root, "Obesidad Mórbida", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.rojo)).show()

               else -> return
           }
       }
    fun showTable(){
        val dialog = TableFragment()
        dialog.show(supportFragmentManager, "TablaPeso")
    }

    }



