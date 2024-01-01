package com.example.capstoneproject.data.decimal

fun Double?.formatToTwoDecimalPlaces(): String{
    return this?.let { "%.2f".format(it) } ?:""
}