package br.com.alura.ceep.webclient.services

import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao
import br.com.alura.ceep.webclient.model.NotaResposta
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface NotaService {

    @GET("notas")
    suspend fun buscaTodas(): List<NotaResposta>

    @PUT("notas/{id}") // o endpoint tem q ter o mesmo nome da variavel do path, mas a variavel do argumento n precisa ser igual
    suspend fun salvar(
        @Path("id") id: String,
        @Body nota: NotaRequisicao
    ): Response<NotaRequisicao>

}