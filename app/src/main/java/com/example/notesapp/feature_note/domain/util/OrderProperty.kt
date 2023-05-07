package com.example.notesapp.feature_note.domain.util

sealed class OrderProperty(val orderType: OrderType) { // sealed class just defines strict inheritance hierarchy
    class Title(orderType: OrderType): OrderProperty(orderType)
    class Date(orderType: OrderType): OrderProperty(orderType)
    class Color(orderType: OrderType): OrderProperty(orderType)
    /*
    * in this case we use classes now since we need a constructor since our orderProperty need to know the orderType
    * the classes inheriting the orderProperty are given an ordertype which they provide to the orderproperty. akin to instantiating a superclass
    * */
}