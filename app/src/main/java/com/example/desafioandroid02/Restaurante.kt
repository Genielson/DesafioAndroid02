package com.example.desafioandroid02

import android.widget.ImageView

data class Restaurante(val titulo:String, val descricao:String, val horario:String,
                       val pratosPrincipais:List<Prato>, val imagemRestaurante:ImageView)

