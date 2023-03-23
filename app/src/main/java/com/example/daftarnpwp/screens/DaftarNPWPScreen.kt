package com.example.daftarnpwp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.daftarnpwp.model.DaftarNPWP
import com.example.daftarnpwp.persistences.AppDatabase
import com.example.daftarnpwp.persistences.DaftarNPWPDao
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun DaftarNPWPScreen() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "daftar-npwp"
    ) .build()

    val DaftarNPWPDao = db.DaftarNPWPDao()
    val list : LiveData<List<DaftarNPWP>> = DaftarNPWPDao.loadAll()
    val items : List<DaftarNPWP> by list.observeAsState(initial = listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        FormDaftarNPWP { item ->
            val newList = ArrayList(list)
            newList.add(item)
            _list.value = newList
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->

                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal lahir", fontSize = 14.sp)
                        Text(text = item.tanggal, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Nama", fontSize = 14.sp)
                        Text(text = item.nama, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Email", fontSize = 14.sp)
                        Text(text = item.email, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }

                }

                Divider(modifier = Modifier.fillMaxWidth())
                        })
                    }
                }
            }
