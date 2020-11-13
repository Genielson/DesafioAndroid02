package com.example.desafioandroid02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class HomeAdapter(var listaRestaurante:List<Restaurante>, private val listener: (Restaurante) -> Unit) : RecyclerView.Adapter<HomeAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var titulo : TextView = view.findViewById<TextView>(R.id.txtTituloRestaurante)

        private var endereco : TextView = view.findViewById<TextView>(R.id.txtEnderecoRestaurante)

        private var horario : TextView = view.findViewById<TextView>(R.id.txtHorarioRestaurante)

        private var imagemRestaurante : ImageView = view.findViewById<ImageView>(R.id.imgItemRestaurante)

        fun bind(restaurante: Restaurante){

            titulo.text = restaurante.titulo

            endereco.text = restaurante.endereco

            horario.text = restaurante.horario

            imagemRestaurante.setImageResource(restaurante.imagemRestaurante)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.lista_restaurante,parent,false)

        return MeuViewHolder(view)

    }

    override fun getItemCount(): Int = listaRestaurante.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(listaRestaurante[position])

        holder.itemView.setOnClickListener {
            listener(listaRestaurante[position])
        }

    }



}