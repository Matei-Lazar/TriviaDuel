package m.matthew.triviaduel.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import m.matthew.triviaduel.data.source.local.QuestionDao
import m.matthew.triviaduel.data.source.local.TriviaDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideTriviaDatabase(@ApplicationContext context: Context): TriviaDatabase {
        return Room.databaseBuilder(
                context,
                TriviaDatabase::class.java,
                TriviaDatabase.DATABASE_NAME
        )
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideQuestionDao(triviaDatabase: TriviaDatabase): QuestionDao {
        return triviaDatabase.questionDao()
    }
}