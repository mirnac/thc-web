package com.treshermanas.thcweb.services.invoices;

import com.treshermanas.thcweb.backingbeans.invoices.customer.Invoice;
import com.treshermanas.thcweb.backingbeans.invoices.customer.SearchOverdueInvoiceFilter;
import com.treshermanas.thcweb.services.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InvoicesServiceImplTest {

	@Autowired
	private InvoicesService invoicesService;

	@Test
	public void testGetOverdueInvoicesForDay(){

		SearchOverdueInvoiceFilter filter = SearchOverdueInvoiceFilter
												.builder()
													.day(10).page(1).pageSize(1000).build();
		PageDto<Invoice> invoiceList = invoicesService.getOverdueInvoices(filter);
		assertNotNull(invoiceList);
	}

}
