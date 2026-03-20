package com.vhausler.springmodulithtest.order.api

@org.springframework.modulith.NamedInterface("api")
interface OrderCreatedEventApi {
    val orderId: String
    val productId: String
    val quantity: Int
}