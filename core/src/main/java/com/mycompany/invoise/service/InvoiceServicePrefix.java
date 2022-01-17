package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;

public abstract class InvoiceServicePrefix implements InvoiceServiceInterface{

    private static long lastNumber = 0L;

    private InvoiceRepositoryInterface invoiceRepositoryMichel;

    public InvoiceRepositoryInterface getInvoiceRepositoryMichel() {
        return invoiceRepositoryMichel;
    }

    public void setInvoiceRepositoryMichel(InvoiceRepositoryInterface invoiceRepositoryMichel) {
        this.invoiceRepositoryMichel = invoiceRepositoryMichel;
    }

    @Override
    public void createInvoice(Invoice invoice){
        invoice.setNumber("INV_" + ++lastNumber);
        invoiceRepositoryMichel.create(invoice);
    }
}

