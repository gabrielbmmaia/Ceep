package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao
import br.com.alura.ceep.webclient.services.NotaService

class NotaWebClient {

    private val notaService: NotaService = RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
        return try {

            val notasResposta = notaService.buscaTodas()

            notasResposta.map { notaResposta ->
                notaResposta.nota
            }

        } catch (e: Exception) {
            Log.e("NotaWebClient", "buscaTodas: ", e)
            null
        } // o try / catch serve para caso ocorra algum imprevisto como falta de internet ele dê nulo em vez ed quebrar o app
    }

    suspend fun salvar(nota: Nota) {
        try {
            val resposta = notaService.salvar(
                nota.id, NotaRequisicao(
                    titulo = nota.titulo,
                    descricao = nota.descricao,
                    imagem = nota.imagem
                )
            )
            if (resposta.isSuccessful) {
                Log.i("NotaWebClient", "salvar: Nota salva com sucesso")
            } else {
                Log.i("NotaWebClient", "salvar: Nota naõ foi salva")
            }
        } catch (e: Exception) {
            Log.e("NotaWebClient", "salvar: ", e)
        }
    }
}