package com.mycompany.invoise.repository;

import com.mycompany.invoise.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements InvoiceRepositoryInterface{


    private static List<Invoice> invoices = new ArrayList<>();

    @Override
    public void create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added with nb " + invoice.getNumber()+ " for " + invoice.getCustomerName());
    }
}
