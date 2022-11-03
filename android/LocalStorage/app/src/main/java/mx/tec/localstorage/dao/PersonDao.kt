package mx.tec.localstorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mx.tec.localstorage.model.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM Person")
    fun getPeople(): List<Person>
    @Insert
    fun insertPerson(persona: Person)
}