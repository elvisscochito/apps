package mx.tec.localstorage.utility

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mx.tec.localstorage.dao.PersonDao
import mx.tec.localstorage.model.Person

@Database(entities = [Person::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDao

    /*static object to admin instance (singleton)*/
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "Agenda").build()
            }
            return INSTANCE as AppDatabase
        }
    }
}