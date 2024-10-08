package com.talespalma.cfopconvertmobile.modules

import android.content.Context
import androidx.room.Room
import com.talespalma.cfopconvertmobile.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
            return Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                "cfop_conver_database"
            ).createFromAsset("database/cfops.db")
                .fallbackToDestructiveMigration()
                .build()

        }


}