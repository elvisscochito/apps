package mx.tec.localstorage.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "Person")
data class Person (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idPerson")
    /*kotlin var*/
    val idPersona: Int,
    /*table name*/
    @ColumnInfo(name = "name")
    val nombre: String,
    @ColumnInfo(name = "lastName")
    val apellido: String,
    @ColumnInfo(name = "age")
    val edad: Int,
    @ColumnInfo(name = "born")
    val born: Date
    )