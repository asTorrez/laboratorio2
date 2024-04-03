package com.example.laboratorio2

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast


class MainActivity : AppCompatActivity(), ContadorListener {

    var fra1:FragmentUno? = null
    var fra2:FragmentDos? = null
    var fra3:FragmentTres? = null

    var cont = 0

    override fun incrementar() {
      cont++
    }

    override fun reducir() {
      if(cont>0)
        cont--
      else
        cont=0
    }

    override fun resetear() {
      cont=0
    }

    override fun getValorActual(): Int {
      return cont
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.includeToolbar)
        setSupportActionBar(toolbar)

        fra1 = FragmentUno()
        fra1!!.addContadorListener(this)
        fra2 = FragmentDos()
        fra2!!.addListener(this)
        fra3 = FragmentTres()
        fra3!!.addCListener(this)

        val btnF1 = findViewById<Button>(R.id.btn1)
        val btnF2 = findViewById<Button>(R.id.btn2)
        val btnF3 = findViewById<Button>(R.id.btn3)

        btnF1.setOnClickListener{
            val trn = supportFragmentManager.beginTransaction()
            trn.replace(R.id.fragmentContainer, fra1!!)
            trn.commit()
        }

        btnF2.setOnClickListener{
            val trn = supportFragmentManager.beginTransaction()
            trn.replace(R.id.fragmentContainer, fra2!!)
            trn.commit()
        }

        btnF3.setOnClickListener{
            val trn = supportFragmentManager.beginTransaction()
            trn.replace(R.id.fragmentContainer, fra3!!)
            trn.commit()
        }
    }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val infla = menuInflater
    infla.inflate(R.menu.menutoolbar,menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val itemId = item.itemId
    if(itemId == R.id.itemGuardar){
      Toast.makeText(this,"Hizo clic en Guardar", Toast.LENGTH_SHORT).show()
    } else if(itemId == R.id.itemAjustes){
      Toast.makeText(this,"Hizo clic en Ajustes", Toast.LENGTH_SHORT).show()
    }
      val sv = item?.actionView as android.widget.SearchView?
      sv?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
          override fun onQueryTextChange(newText: String?): Boolean {
              val activity = sv.context as MainActivity
              Toast.makeText(activity, newText, Toast.LENGTH_SHORT). show()
              return true
          }

          override fun onQueryTextSubmit(query: String?): Boolean {
              val activity = sv.context as MainActivity
              Toast.makeText(activity, "Buscar: "+query, Toast.LENGTH_SHORT). show()
              return true
          }
      })

    return super.onOptionsItemSelected(item)
  }





}
