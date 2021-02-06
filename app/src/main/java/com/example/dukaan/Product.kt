package com.example.dukaan

data class Product(
    val orderId: String,
    val isNew: Boolean,
    val itemName: String,
    val timeData: String,
    val paymentType: PaymentType,
    val price: Int,
    val deliveryStatus : DeliveryStatus,
    val productImgResId : Int,
    val paymentColor : Int
)


enum class PaymentType(val type: String, val paymentColor : Int) {
    COD("COD", R.color.dusty_orange),
    PAID("PAID", R.color.cherry_red)
}

enum class DeliveryStatus(val status : String) {
    SHIPPED("Shipped"),
    ACCEPTED("Accepted"),
    PENDING("Pending")
}