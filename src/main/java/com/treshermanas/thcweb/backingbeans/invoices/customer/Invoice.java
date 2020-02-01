package com.treshermanas.thcweb.backingbeans.invoices.customer;

import com.treshermanas.thcweb.beans.thirdperson.ThirdPerson;

public class Invoice {

    private Integer id;
    private String facNumber;
    private ThirdPerson thirdPerson;
    private PaymentTerm paymentTerm;

    public Invoice(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }

    public ThirdPerson getThirdPerson() {
        return thirdPerson;
    }

    public void setThirdPerson(ThirdPerson thirdPerson) {
        this.thirdPerson = thirdPerson;
    }

    public PaymentTerm getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        this.paymentTerm = paymentTerm;
    }
}
