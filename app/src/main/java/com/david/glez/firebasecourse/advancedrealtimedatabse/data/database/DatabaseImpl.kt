package com.david.glez.firebasecourse.advancedrealtimedatabse.data.database

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.david.glez.firebasecourse.advancedrealtimedatabse.domain.DatabaseService
import javax.inject.Inject

class DatabaseImpl @Inject constructor(private val context: Context): DatabaseService {

    companion object {
        private val USER_NAME = stringPreferencesKey("username")
    }

    private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(name = "users")

    override suspend fun saveUserName(nickname: String) {
        context.userPreferencesDataStore.edit { preferences ->
            preferences[USER_NAME] = nickname
        }
    }
}