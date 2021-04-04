package m.matthew.triviaduel.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import m.matthew.triviaduel.data.source.remote.TriviaApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // instead of ApplicationComponent
object RetrofitModule {

    private const val BASE_URL = "https://opentdb.com/"

    @Singleton
    @Provides
    fun provideMoshiBuilder(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun provideTriviaApiService(retrofitService: Retrofit.Builder): TriviaApiService {
        return retrofitService
                .build()
                .create(TriviaApiService::class.java)
    }
}