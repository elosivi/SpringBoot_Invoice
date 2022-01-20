package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;

import java.io.File;

public class InvoiceServicePrefix implements InvoiceServiceInterface{

    private static long lastNumber;
    private String prefix;
    //private File fichier;

    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepositoryMichel) {
        this.invoiceRepository = invoiceRepositoryMichel;
    }

    @Override
    public void createInvoice(Invoice invoice){
        invoice.setNumber(prefix + ++lastNumber);
        invoiceRepository.create(invoice);
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

