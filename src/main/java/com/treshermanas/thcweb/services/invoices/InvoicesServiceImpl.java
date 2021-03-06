package com.treshermanas.thcweb.services.invoices;

import com.treshermanas.thcweb.backingbeans.invoices.customer.Invoice;
import com.treshermanas.thcweb.backingbeans.invoices.customer.SearchOverdueInvoiceFilter;
import com.treshermanas.thcweb.beans.invoice.customers.OverdueSummary;
import com.treshermanas.thcweb.exception.ThcServiceException;
import com.treshermanas.thcweb.services.dto.PageDto;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.dto.invoices.InvoiceDto;
import com.treshermanas.thcweb.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class InvoicesServiceImpl implements InvoicesService {

    @Value("${backend.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    private ModelMapper modelMapper;

    public InvoicesServiceImpl(RestTemplate restTemplate, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    @Override
    public Resource getUnpaidInvoicesByMonthAndYear(String monthYear) {

            try{

                if(DateUtils.isValidWebMonthYearFormat(monthYear)) {

                    String url = baseUrl + GET_UNPAID_INVOICES_REPORT_URL;

                    UriComponentsBuilder builder = UriComponentsBuilder
                            .fromUriString(url)
                            .queryParam("invoice_date", DateUtils.changeDateFormat(
                                    DateUtils.WEB_MONTH_YEAR_FORMAT,
                                    DateUtils.API_MONTH_YEAR_FORMAT,
                                    monthYear
                            ));

                    return restTemplate.getForObject(builder.toUriString(), Resource.class);

                }else{
                    throw new ThcServiceException(
                            String.format("Invalid month and year format. Expected MM-yyyy - Received %s",monthYear));
                }

            }catch (ParseException e){
                throw new ThcServiceException("Error trying to parse date to api format ",e);
            }
    }

    @Override
    public Invoice getInvoice(Integer invoiceId) {

        String url = baseUrl + GET_INVOICE_URL;
        UriComponents builder = UriComponentsBuilder
                .fromUriString(url)
                .buildAndExpand(invoiceId);

        InvoiceDto invoiceDto =  restTemplate.getForObject(builder.toUriString(),InvoiceDto.class);

        return modelMapper.map(invoiceDto,Invoice.class);
    }

    @Override
    public List<OverdueSummary> getOverdueInvoicesAmountSummary() {
        String url = baseUrl + GET_OVERDUE_SUMMARY_URL;
        UriComponents builder = UriComponentsBuilder
                .fromUriString(url)
                .build();

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<OverdueSummary>>() {}).getBody();
    }

    @Override
    public PageDto<Invoice> getOverdueInvoices(SearchOverdueInvoiceFilter filter) {

        String url = baseUrl + GET_OVERDUE_INVOICES;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateUtils.API_DATE_FORMAT);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url);

        builder.queryParam("day", filter.getDay());
        builder.queryParam("page", filter.getPage());
        builder.queryParam("size", filter.getPageSize());

        if(filter.getFromDate() != null)
            builder.queryParam("from", formatter.format(filter.getFromDate()));

        if(filter.getUntilDate() != null)
            builder.queryParam("until",formatter.format(filter.getUntilDate()));

        PageDto<InvoiceDto> invoiceDtoPageDto =  restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
                null, new ParameterizedTypeReference<PageDto<InvoiceDto>>() {
                }).getBody();

        java.lang.reflect.Type type = new TypeToken<List<Invoice>>() {}.getType();


        PageDto<Invoice> invoicesPage = new PageDto<>(invoiceDtoPageDto.getNumber(),invoiceDtoPageDto.getPageSize());
        invoicesPage.setTotalPagesCount(invoiceDtoPageDto.getTotalPagesCount());
        invoicesPage.setData(
                modelMapper.map(invoiceDtoPageDto.getData(),type)
        );
        return invoicesPage;
    }

    @Override
    public PageDto<Invoice> getOverdueInvoicesReport(SearchOverdueInvoiceFilter filter) {

        String url = baseUrl + GET_OVERDUE_INVOICES_REPORT;

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url);

        builder.queryParam("day", filter.getDay());
        builder.queryParam("page", filter.getPage());
        builder.queryParam("size", filter.getPageSize());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateUtils.API_DATE_FORMAT);
        if(filter.getFromDate() != null)
            builder.queryParam("from", formatter.format(filter.getFromDate()));

        if(filter.getUntilDate() != null)
            builder.queryParam("until",formatter.format(filter.getUntilDate()));

        return null;

    }

}
