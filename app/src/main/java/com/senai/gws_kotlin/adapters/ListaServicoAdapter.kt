package com.senai.gws_kotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.senai.gws_kotlin.R
import com.senai.gws_kotlin.models.Membros

class ListaServicoAdapter(
    private val context: Context,
    private val listaServicos: List<Membros>
) : RecyclerView.Adapter<ListaServicoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //Essa função é responsável por chamar e atribuir valores para as views do item da RecyclerView
        fun vincularDadosNoItem(membro: Membros) {
            val tituloServico = itemView.findViewById<TextView>(R.id.nomeServico)
            tituloServico.text = membro.nome

            val descricaoServico = itemView.findViewById<TextView>(R.id.descricaoServico)
            descricaoServico.text = membro.sobrenome

            val propostaServico = itemView.findViewById<TextView>(R.id.valorServico)
            propostaServico.text = membro.email




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaServicoAdapter.ViewHolder {
        val inflater = LayoutInflater.from(context);

        val view = inflater.inflate(R.layout.fragment_servico, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaServicoAdapter.ViewHolder, position: Int) {
        val itemServico = listaServicos[position]

        holder.vincularDadosNoItem(itemServico)
    }

    override fun getItemCount(): Int {
        return listaServicos.size
    }
}