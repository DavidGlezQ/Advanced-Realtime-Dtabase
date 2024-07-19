package com.david.glez.firebasecourse.advancedrealtimedatabse.di

import android.content.Context
import com.david.glez.firebasecourse.advancedrealtimedatabse.data.database.DatabaseServiceImpl
import com.david.glez.firebasecourse.advancedrealtimedatabse.data.network.FirebaseChatService
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.DatabaseService
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun providesDataBaseReference() = Firebase.database.reference

    @Singleton
    @Provides
    fun provideFirebaseService(reference: DatabaseReference) = FirebaseChatService(reference = reference)

    @Singleton
    @Provides
    fun provideDataStoreService(@ApplicationContext context: Context) : DatabaseService {
        return DatabaseServiceImpl(context = context)
    }
}