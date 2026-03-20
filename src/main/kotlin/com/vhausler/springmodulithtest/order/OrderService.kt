package com.vhausler.springmodulithtest.order

import com.vhausler.springmodulithtest.order.api.OrderCreatedEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(private val eventPublisher: ApplicationEventPublisher) {

    @Transactional
    fun createOrder(productId: String, quantity: Int) {
        val orderId = "order-" + System.currentTimeMillis()
        eventPublisher.publishEvent(OrderCreatedEvent(orderId, productId, quantity))
    }
}