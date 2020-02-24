package com.treshermanas.thcweb.services.dto.products;

import com.treshermanas.thcweb.beans.products.DetailStatus;
import com.treshermanas.thcweb.services.dto.invoices.SupplierInvoiceDto;
import com.treshermanas.thcweb.services.dto.thirdparty.SupplierDto;

import java.time.LocalDate;

public class ProductDetailDto {

    private DetailStatus status;
    private String barcode;
    private ProductDto product;
    private SupplierDto supplier;
    private SupplierInvoiceDto supplierInvoice;
    private LocalDate created;

    public ProductDetailDto(){

    }

    public DetailStatus getStatus() {
        return status;
    }

    public void setStatus(DetailStatus status) {
        this.status = status;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public SupplierInvoiceDto getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoiceDto supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
