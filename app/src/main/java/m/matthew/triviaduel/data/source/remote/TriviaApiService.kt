package m.matthew.triviaduel.data.source.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import m.matthew.triviaduel.data.model.TriviaResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://opentdb.com/"

//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()

interface TriviaApiService {

    @GET("api.php?amount=1&type=multiple")
    suspend fun getQuestion(): TriviaResponse
}

//object TriviaApi {
//    val retrofitService : TriviaApiService by lazy { retrofit.create(TriviaApiService::class.java) }
//}