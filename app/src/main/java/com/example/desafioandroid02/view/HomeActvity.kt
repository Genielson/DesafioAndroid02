package com.example.desafioandroid02.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid02.R
import com.example.desafioandroid02.model.Restaurante
import com.example.desafioandroid02.view.adapter.HomeAdapter

class HomeActvity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_actvity)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRestaurant)

        setupRecyclerView()

    }

    fun setupRecyclerView(){

        var manager = LinearLayoutManager(this)

        recyclerView.apply{

            setHasFixedSize(true)
            layoutManager = manager

            adapter = setupAdapter()

        }

    }

    fun setupAdapter(): HomeAdapter {

        return HomeAdapter(
            listOf(
                Restaurante(
                    "Tony Roma's",
                    "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                    "Fecha às 22:00",
                    R.drawable.primeiro_item
                ),

                Restaurante(
                    "Tony Roma's",
                    "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                    "Fecha às 22:00",
                    R.drawable.segundo_item
                ),

                Restaurante(
                    "Tony Roma's",
                    "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                    "Fecha às 22:00",
                    R.drawable.terceiro_item
                ),

                Restaurante(
                    "Tony Roma's",
                    "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                    "Fecha às 22:00",
                    R.drawable.quarto_item
                )

            )
        ) {

            var intent = Intent(
                this,
                RestauranteActivity::class.java
            )

            intent.putExtra("TITULO_RESTAURANTE", it.titulo)
            intent.putExtra("IMAGEM_RESTAURANTE", it.imagemRestaurante)

            startActivity(intent)

        }

    }

}