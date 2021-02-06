package com.example.dukaan


val overViewData = linkedMapOf<String, List<Overview>>(
    "Last Week" to listOf<Overview>(
        Overview("Orders", "33"),
        Overview("Total sales", "₹2,918"),
        Overview("Store Views", "301"),
        Overview("Product Views", "19,121")
    ),
    "Last Month" to listOf<Overview>(
        Overview("Orders", "9"),
        Overview("Total sales", "₹1,908"),
        Overview("Store Views", "908"),
        Overview("Product Views", "1,927")
    ),
    "Last 6 Months" to listOf<Overview>(
        Overview("Orders", "78"),
        Overview("Total sales", "₹918"),
        Overview("Store Views", "11"),
        Overview("Product Views", "1,120")
    ),
    "Last Year" to listOf<Overview>(
        Overview("Orders", "80"),
        Overview("Total sales", "₹18,7435"),
        Overview("Store Views", "90001"),
        Overview("Product Views", "11,121")
    )
)

val products = listOf<Product>(
    Product(
        "Order #281217", true, "1 item", "Today, 11:11 PM",
        PaymentType.COD, 79, DeliveryStatus.PENDING, R.drawable.item_1, R.color.dusty_orange
    ),Product(
        "Order #281218", true, "1 item", "Yesterday, 12:10 PM",
        PaymentType.PAID, 399, DeliveryStatus.PENDING, R.drawable.item_2, R.color.cherry_red
    ),Product(
        "Order #281217", false, "1 item", "Yesterday, 09:12 PM",
        PaymentType.PAID, 410, DeliveryStatus.PENDING, R.drawable.item_3, R.color.cherry_red
    )
)


