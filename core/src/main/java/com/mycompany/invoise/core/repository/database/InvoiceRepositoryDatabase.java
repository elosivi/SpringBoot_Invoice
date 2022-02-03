package com.mycompany.invoise.core.repository.database;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    //@Autowired
   // private JdbcTemplate jdbcTemplate;
    private static List<Invoice> invoices = new ArrayList<>();

    @Override
    public void create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added with nb " + invoice.getNumber()+ " for " + invoice.getCustomerName());
    }

    @Override
    public List<Invoice> list(){
        Invoice invoice1 = new Invoice();
        invoice1.setNumber("NUM_1");
        invoice1.setCustomerName("TOTO");
        Invoice invoice2 = new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("TOTO-2");

        return List.of(invoice1,invoice2);
    }

    @Override
    public Invoice getById(String number) {
       Invoice invoice1 = new Invoice();
       invoice1.setNumber(number);
       invoice1.setCustomerName("TOTO");
       invoice1.setOrderNumber("ON_002");
       return invoice1;
    }
}
