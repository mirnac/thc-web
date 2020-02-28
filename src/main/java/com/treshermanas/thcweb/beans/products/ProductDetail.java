package com.treshermanas.thcweb.beans.products;

import com.treshermanas.thcweb.beans.invoice.suppliers.SupplierInvoice;
import com.treshermanas.thcweb.beans.thirdperson.Supplier;

import java.time.LocalDate;

public class ProductDetail {

    private DetailStatus status;
    private String barcode;
    private Product product;
    private Supplier supplier;
    private SupplierInvoice supplierInvoice;
    private LocalDate created;

    public ProductDetail(){

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public SupplierInvoice getSupplierInvoice() {
        return supplierInvoice;
    }

    public void setSupplierInvoice(SupplierInvoice supplierInvoice) {
        this.supplierInvoice = supplierInvoice;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
