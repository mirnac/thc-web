package com.treshermanas.thcweb.services.invoices;

import com.treshermanas.thcweb.backingbeans.invoices.customer.Invoice;
import com.treshermanas.thcweb.exception.ThcServiceException;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.dto.invoices.InvoiceDto;
import com.treshermanas.thcweb.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;

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

}
