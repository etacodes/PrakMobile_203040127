package com.example.daftarnpwp.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.daftarnpwp.model.DaftarNPWP

@Dao
interface DaftarNPWPDao {
    @Query("SELECT * FROM DaftarNPWP")
    fun loadAll() : LiveData<List<DaftarNPWP>>

    @Query("SELECT * FROM DaftarNPWP WHERE id = :id")
    fun find(id: String) : DaftarNPWP?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items:DaftarNPWP)

    @Delete
    fun delete(item: DaftarNPWP)

    companion object {
        fun insertAll(item: DaftarNPWP) {

        }
    }
}