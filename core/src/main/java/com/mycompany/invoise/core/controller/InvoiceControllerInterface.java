package com.mycompany.invoise.core.controller;


import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.core.entity.Invoice;

public interface InvoiceControllerInterface {
    String createInvoice(Invoice invoice);
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
