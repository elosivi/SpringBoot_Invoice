package com.mycompany.invoise.invoiseweb.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class InvoiceForm {

    //@Pattern(regexp="INV")
    @Size(min=10,max=13)
    private String number;
    @NotBlank(message="Un nom de client doit être renseigné")
    private String customerName;
    private String orderNumber;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
