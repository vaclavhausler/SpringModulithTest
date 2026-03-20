package com.vhausler.springmodulithtest.order.api

data class OrderCreatedEvent(
    override val orderId: String,
    override val productId: String,
    override val quantity: Int
) : OrderCreatedEventApi