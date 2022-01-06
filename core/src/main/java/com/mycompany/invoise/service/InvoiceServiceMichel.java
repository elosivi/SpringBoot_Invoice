package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepository;

public class InvoiceServiceMichel {

    private static long lastNumber = 0L;

    private InvoiceRepository invoiceRepository = new InvoiceRepository();

    public void createInvoice(Invoice invoice){
        invoice.setNumber("INV_" + ++lastNumber);
        invoiceRepository.create(invoice);
    }
}

