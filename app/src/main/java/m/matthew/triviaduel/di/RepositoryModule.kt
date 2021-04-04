package m.matthew.triviaduel.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import m.matthew.triviaduel.data.source.local.LocalMapper
import m.matthew.triviaduel.data.source.local.QuestionDao
import m.matthew.triviaduel.data.source.remote.TriviaApiService
import m.matthew.triviaduel.data.source.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        questionDao: QuestionDao,
        triviaApiService: TriviaApiService,
        localMapper: LocalMapper
    ): MainRepository {
        return MainRepository(questionDao, triviaApiService, localMapper)
    }
}