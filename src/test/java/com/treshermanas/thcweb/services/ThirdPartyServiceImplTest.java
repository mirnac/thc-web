package com.treshermanas.thcweb.services;

import com.treshermanas.thcweb.beans.thirdperson.Supplier;
import com.treshermanas.thcweb.services.thirdparty.ThirdPartyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ThirdPartyServiceImplTest {

    @Autowired
    private ThirdPartyService thirdPartyService;

    @Test
    void getAllSuppliers() {

        List<Supplier> suppliers = thirdPartyService.getAllSuppliers();
        assertNotNull(suppliers);
        assertTrue(suppliers.size() > 0);
    }

}