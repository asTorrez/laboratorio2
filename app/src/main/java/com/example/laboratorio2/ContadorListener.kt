package com.example.laboratorio2

interface ContadorListener {
    fun incrementar()

    fun reducir()

    fun resetear()

    fun getValorActual():Int
}