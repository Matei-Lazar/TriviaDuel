package m.matthew.triviaduel.data.source.remote

import m.matthew.triviaduel.data.model.TriviaResponse
import retrofit2.http.GET

interface TriviaApiService {

    @GET("api.php?amount=1&type=multiple")
    suspend fun getQuestion(): TriviaResponse

    @GET("api.php?amount=50&type=multiple")
    suspend fun getAny50Questions(): TriviaResponse

    @GET("api_token.php?command=request")
    suspend fun getToken(): String
}