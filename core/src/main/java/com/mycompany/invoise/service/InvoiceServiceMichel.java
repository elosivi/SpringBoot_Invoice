package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepository;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.repository.InvoiceRepositoryMichel;

public class InvoiceServiceMichel implements InvoiceServiceInterface{

    private static long lastNumber = 0L;

    private InvoiceRepositoryInterface invoiceRepositoryMichel;

    @Override
    public void createInvoice(Invoice invoice){
        invoice.setNumber("INV_" + ++lastNumber);
        invoiceRepositoryMichel.create(invoice);
    }
}

