package com.example.capstoneproject.data.converters

import androidx.compose.runtime.snapshots.SnapshotStateList

fun convertToSnapshotStateList(
    arrayList: List<String>,
    checkList: List<String>,
): SnapshotStateList<String> {
    val snapshotStateList = SnapshotStateList<String>()

    for (item in arrayList) {
        for (items in checkList) {
            if (item == items) {
                snapshotStateList.add(item)
            }
        }
    }
    return snapshotStateList
}
