package com.vhausler.springmodulithtest

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.test.ApplicationModuleTest

@ApplicationModuleTest
class ModulithStructureTest {

    @Test
    fun `verify module boundaries`() {
        ApplicationModules.of(SpringModulithTestApplication::class.java).verify()
    }
}