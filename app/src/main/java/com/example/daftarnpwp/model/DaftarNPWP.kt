package com.example.daftarnpwp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class DaftarNPWP(
    @PrimaryKey val id: String,
    val tanggal: String,
    val nama: String,
    val email: String
)
