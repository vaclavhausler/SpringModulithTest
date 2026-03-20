package com.vhausler.springmodulithtest.inventory

import com.vhausler.springmodulithtest.order.api.OrderCreatedEventApi
import org.springframework.stereotype.Service
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Service
class InventoryService {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun on(event: OrderCreatedEventApi) {
        println("Reserving stock for ${event.productId}")
    }
}