package com.example.notesapp.feature_note.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
    // we have to use objects. if we tried to use classes, we would be forced to add constructor
    // .. inputs to differentiate btn different instances
}