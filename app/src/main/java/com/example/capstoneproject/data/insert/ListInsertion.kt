package com.example.capstoneproject.data.insert

import androidx.compose.runtime.snapshots.SnapshotStateList

fun addToListForInsert(list: SnapshotStateList<String>) : ArrayList<String>{
    val itemList: ArrayList<String> = ArrayList()
    itemList.addAll(list)
    return itemList
}
