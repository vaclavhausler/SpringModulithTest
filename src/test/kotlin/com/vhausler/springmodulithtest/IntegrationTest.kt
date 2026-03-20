package com.vhausler.springmodulithtest

import com.vhausler.springmodulithtest.inventory.InventoryService
import com.vhausler.springmodulithtest.order.OrderService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class IntegrationTest {

    @Autowired
    lateinit var orderService: OrderService

    @MockitoSpyBean
    lateinit var inventoryService: InventoryService

    @Test
    fun `order triggers inventory`() {
        orderService.createOrder("product-1", 2)

        verify(inventoryService).on(any())
    }
}