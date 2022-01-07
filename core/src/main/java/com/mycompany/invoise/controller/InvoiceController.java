package com.mycompany.invoise.controller;

import com.mycompany.invoise.App;
import com.mycompany.invoise.entity.Invoice;


import java.util.Scanner;

public class InvoiceController implements InvoiceControllerInterface{

    private InvoiceControllerInterface invoiceService;

    @Override
    public void createInvoice(){
        System.out.println( "What is the customer name?" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);

        AddOne();

    }

    public void AddOne(){
        System.out.println(" Add one more invoice? Y/N");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();

        if(response.equalsIgnoreCase("y")){
            App.choiceInvoiceConfiguration();
        }else if( response.equalsIgnoreCase("n")) {
            System.out.println("Ok thank!");
        }else{
            System.out.println("wrong choice, please try again");
            AddOne();
        }
    }
}
