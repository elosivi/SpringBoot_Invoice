package com.mycompany.invoise.controller;

import com.mycompany.invoise.App;
import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceServiceInterface;


import java.util.Scanner;

public class InvoiceControllerWeb implements InvoiceControllerInterface{

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice(){
        //System.out.println( "What is the customer name?" );
        String customerName = "Customer from web";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        invoiceService.createInvoice(invoice);

        //AddOne();
    }

//    public void AddOne(){
//        System.out.println(" Add one more invoice? Y/N");
//        Scanner sc = new Scanner(System.in);
//        String response = sc.nextLine();
//
//        if(response.equalsIgnoreCase("y")){
//            App.choiceInvoiceConfiguration();
//        }else if( response.equalsIgnoreCase("n")) {
//            System.out.println("Ok thank!");
//        }else{
//            System.out.println("wrong choice, please try again");
//            AddOne();
//        }
//    }
}
