package com.mycompany.invoise.core.controller.keyboard;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;



import java.util.Scanner;
//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice(){
        System.out.println( "What is the customer name?" );
        Invoice invoice = new Invoice();

        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);

        AddOne();

    }

    public void AddOne(){
        System.out.println(" Add one more invoice? Y/N");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();

        if(response.equalsIgnoreCase("y")){
            System.out.println("ok restart");
        }else if( response.equalsIgnoreCase("n")) {
            System.out.println("Ok thank!");
        }else{
            System.out.println("wrong choice, please try again");
            AddOne();
        }
    }
}
