package com.senai.gws_kotlin.models

import java.util.UUID

class Servico (
    val idServico: UUID,
    val titulo: String,
    val descricao: String,
    val proposta: String
)