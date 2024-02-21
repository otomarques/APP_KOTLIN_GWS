package com.senai.gws_kotlin.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.senai.gws_kotlin.adapters.ListaServicoAdapter
import com.senai.gws_kotlin.apis.EndpointInterface
import com.senai.gws_kotlin.apis.RetrofitConfig
import com.senai.gws_kotlin.databinding.FragmentListaServicosBinding
import com.senai.gws_kotlin.models.Membros
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaServicosFragment : Fragment() {

    private val clienteRetrofit = RetrofitConfig.create()

    private val endpoints = clienteRetrofit.create(EndpointInterface::class.java)

    private var _binding: FragmentListaServicosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListaServicosBinding.inflate(inflater, container, false)

        val root: View = binding.root

        // organiza os itens da Recycler em ordem vertical, sendo um debaixo do outro
        binding.recyclerServicos.layoutManager = LinearLayoutManager(requireContext())

        endpoints.listarServicos().enqueue(object : Callback<List<Membros>> {
            override fun onResponse(call: Call<List<Membros>>, response: Response<List<Membros>>) {
                val membros = response.body()
                binding.recyclerServicos.adapter = membros?.let { ListaServicoAdapter(requireContext(), it) }

            }

            override fun onFailure(call: Call<List<Membros>>, t: Throwable) {
                println("Falha na requisição: ${t.message}")
            }

        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}