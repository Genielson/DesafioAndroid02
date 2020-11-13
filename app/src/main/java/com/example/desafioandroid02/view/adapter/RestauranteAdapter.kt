package com.example.desafioandroid02.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid02.R
import com.example.desafioandroid02.model.Prato

class RestauranteAdapter(val listaPrato: List<Prato>, private val listener  : (Prato) -> Unit) : RecyclerView.Adapter<RestauranteAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View):RecyclerView.ViewHolder(view){

        private var titulo : TextView = view.findViewById<TextView>(R.id.txtTituloPrato)

        private var imagemPrato : ImageView = view.findViewById<ImageView>(R.id.imgItemPrato)

        private lateinit var descricao : String

        fun bind(prato: Prato) {

            titulo.text = prato.titulo

            imagemPrato.setImageResource(prato.imagemPrato)

            descricao = prato.descricaoDoPrato

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {


        var view = LayoutInflater.from(parent.context).inflate(R.layout.lista_pratos,parent,false)

        return MeuViewHolder(
            view
        )

    }

    override fun getItemCount(): Int = listaPrato.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {

        holder.bind(listaPrato[position])

        holder.itemView.setOnClickListener {
            listener(listaPrato[position])
        }

    }

}