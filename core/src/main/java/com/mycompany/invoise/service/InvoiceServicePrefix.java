package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;

import java.io.File;

public abstract class InvoiceServicePrefix implements InvoiceServiceInterface{

    private static long lastNumber;
    private String prefix;
    private File fichier;

    private InvoiceRepositoryInterface invoiceRepositoryMichel;

    public InvoiceRepositoryInterface getInvoiceRepositoryMichel() {
        return invoiceRepositoryMichel;
    }

    public void setInvoiceRepositoryMichel(InvoiceRepositoryInterface invoiceRepositoryMichel) {
        this.invoiceRepositoryMichel = invoiceRepositoryMichel;
    }

    @Override
    public void createInvoice(Invoice invoice){
        invoice.setNumber(prefix + ++lastNumber);
        invoiceRepositoryMichel.create(invoice);
    }

    public static long getLastNumber() {
        return lastNumber;
    }

    public static void setLastNumber(long lastNumber) {
        InvoiceServicePrefix.lastNumber = lastNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

