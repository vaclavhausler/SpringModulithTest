package com.vhausler.springmodulithtest.order

import com.vhausler.springmodulithtest.order.api.OrderCreatedEventApi
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.modulith.test.PublishedEvents
import kotlin.test.assertTrue

@Suppress("SpringJavaInjectionPointsAutowiringInspection") // works absolutely fine, IDEA just whines about autowiring the events
@ApplicationModuleTest
class OrderModuleTest {

    @Autowired
    lateinit var orderService: OrderService

    @Autowired
    lateinit var events: PublishedEvents

    @Test
    fun `publishes OrderCreatedEvent`() {
        orderService.createOrder("product-1", 2)

        // Verify that an OrderCreatedEvent was published
        assertTrue(events.eventOfTypeWasPublished(OrderCreatedEventApi::class.java))
    }
}