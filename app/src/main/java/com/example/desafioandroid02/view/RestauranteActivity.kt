package com.example.desafioandroid02.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid02.R
import com.example.desafioandroid02.model.Prato
import com.example.desafioandroid02.view.adapter.RestauranteAdapter
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

        setupBackButton()

        setupInfosRestaurante()

        setupRecyclerView()

    }

    fun setupRecyclerView(){

        recyclerView = findViewById<RecyclerView>(R.id.recyclerViewListaPratos)

        var manager = GridLayoutManager(this,2)

        recyclerView.apply{

            setHasFixedSize(true)
            layoutManager = manager

            adapter = setupAdapter()

        }
    }

    fun setupAdapter(): RestauranteAdapter {

        return RestauranteAdapter(
            listOf(

                Prato(
                    "Salada com molho Gengibre",
                    "Sed ut perspiciatis, unde omnis iste natus " +
                            "error sit voluptatem accusant doloremque laudantium, " +
                            "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",
                    R.drawable.imgprato
                ),

                Prato(
                    "Salada com molho Gengibre",
                    "Sed ut perspiciatis, unde omnis iste natus " +
                            "error sit voluptatem accusant doloremque laudantium, " +
                            "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",
                    R.drawable.imgprato
                ),

                Prato(
                    "Salada com molho Gengibre",
                    "Sed ut perspiciatis, unde omnis iste natus " +
                            "error sit voluptatem accusant doloremque laudantium, " +
                            "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",
                    R.drawable.imgprato
                ),

                Prato(
                    "Salada com molho Gengibre",
                    "Sed ut perspiciatis, unde omnis iste natus " +
                            "error sit voluptatem accusant doloremque laudantium, " +
                            "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",
                    R.drawable.imgprato
                )
            )
        ) {

            val intent = Intent(
                this,
                ItemRestauranteActivity::class.java
            )

            intent.putExtra("TITULO_ITEM_RESTAURANTE", it.titulo)
            intent.putExtra("DESCRICAO_ITEM_RESTAURANTE", it.descricaoDoPrato)
            intent.putExtra("IMAGEM_RESTAURANTE", it.imagemPrato)

            startActivity(intent)

        }

    }

    fun setupInfosRestaurante(){

        var titulo = intent.getStringExtra("TITULO_RESTAURANTE")

        var imagem = intent.getIntExtra("IMAGEM_RESTAURANTE",0)

        var imagemRestaurante = findViewById<ImageView>(R.id.imgRestaurante)

        txtNomeRestaurante.text = titulo.toString()

        imagemRestaurante.setImageResource(imagem)

    }

    fun setupBackButton(){

        buttonBack = findViewById(R.id.imageButtonBackId)

        buttonBack.setOnClickListener {

            finish()

        }

    }


}