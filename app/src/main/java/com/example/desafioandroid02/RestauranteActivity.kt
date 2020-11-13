package com.example.desafioandroid02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_restaurante.*
import kotlinx.android.synthetic.main.lista_restaurante.*
import org.w3c.dom.Text

class RestauranteActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    //private lateinit var tituloRestaurante : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

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

    fun setupAdapter():RestauranteAdapter{

        return RestauranteAdapter(listOf(

            Prato("Salada com molho Gengibre","Sed ut perspiciatis, unde omnis iste natus " +
                "error sit voluptatem accusant doloremque laudantium, " +
                "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",R.drawable.imgprato),

            Prato("Salada com molho Gengibre","Sed ut perspiciatis, unde omnis iste natus " +
                    "error sit voluptatem accusant doloremque laudantium, " +
                    "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",R.drawable.imgprato),

            Prato("Salada com molho Gengibre","Sed ut perspiciatis, unde omnis iste natus " +
                    "error sit voluptatem accusant doloremque laudantium, " +
                    "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",R.drawable.imgprato),

            Prato("Salada com molho Gengibre","Sed ut perspiciatis, unde omnis iste natus " +
                    "error sit voluptatem accusant doloremque laudantium, " +
                    "totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",R.drawable.imgprato))){

            val intent = Intent(this,ItemRestauranteActivity::class.java)

            intent.putExtra("ITEM_RESTAURANTE",it.descricaoDoPrato)
            intent.putExtra("IMAGEM_RESTAURANTE",it.imagemPrato)

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

}