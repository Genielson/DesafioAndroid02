package com.example.desafioandroid02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_restaurante.*

class ItemRestauranteActivity : AppCompatActivity() {

    private lateinit var tituloItem:TextView
    private lateinit var descricaoItem:TextView
    private lateinit var imagemItem:ImageView
    private lateinit var buttonBack:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_restaurante)

        setupBackButton()

        setupInfoItemRestaurante()

    }



    fun setupInfoItemRestaurante(){

        var titulo = intent.getStringExtra("TITULO_ITEM_RESTAURANTE")

        var descricao = intent.getStringExtra("DESCRICAO_ITEM_RESTAURANTE")

        var imagem = intent.getIntExtra("IMAGEM_RESTAURANTE",0)

        tituloItem = findViewById(R.id.txtNomeItemRestaurante)

        descricaoItem = findViewById(R.id.txtItemDescricao)

        imagemItem = findViewById(R.id.imgItemRestaurante)

        tituloItem.text = titulo.toString()

        descricaoItem.text = descricao.toString()

        imagemItem.setImageResource(imagem)

    }

    fun setupBackButton(){

        buttonBack = findViewById(R.id.backButtonId)

        buttonBack.setOnClickListener {
            finish()
        }
    }


}