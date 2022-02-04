package com.mycompany.invoise.core.repository.database;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static List<Invoice> invoices = new ArrayList<>();

    @Override
    public void create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added with nb " + invoice.getNumber()+ " for " + invoice.getCustomerName());
    }

    @Override
    public List<Invoice> list(){
        return jdbcTemplate.query("SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE",
                (rs,rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("CUSTOMER_NAME")));
    }

    @Override
    public Invoice getById(String number) {
        return jdbcTemplate.queryForObject("SELECT INVOICE_NUMBER, ORDER_NUMBER, CUSTOMER_NAME FROM INVOICE WHERE INVOICE_NUMBER=?",
                new Object[]{number},
                (rs,rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")), rs.getString("ORDER_NUMBER"), rs.getString("CUSTOMER_NAME")));
    }
}
