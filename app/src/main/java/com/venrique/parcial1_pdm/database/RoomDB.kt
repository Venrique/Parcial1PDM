package com.venrique.parcial1_pdm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.venrique.parcial1_pdm.database.DAO.partidoDAO
import com.venrique.parcial1_pdm.database.entidades.Partido

@Database(entities = [Partido::class],version = 1,exportSchema = false)
abstract class RoomDB: RoomDatabase() {

    abstract fun partidoDao():partidoDAO

    companion object{
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB {
            if (INSTANCE != null) return INSTANCE !!
            else
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(context, RoomDB::class.java, "Partidos_Database")
                        .build()

                    return INSTANCE !!
                }

        }
    }

}