package com.mycompany.invoise;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceService;
import com.mycompany.invoise.service.InvoiceServiceMichel;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        System.out.println( "WELCOME !" );
        System.out.println( "You want to add one or more invoices. Let's Start !");
        addInvoice();
    }

    public static Invoice addInvoice(){
        System.out.println( "What is the customer name?" );
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        choiceInvoiceConfiguration(invoice);

        return invoice;
    }

    public static void choiceInvoiceConfiguration(Invoice invoice){
        System.out.println(" What is your configuration? 1 ou 2 ?");
        Scanner sc = new Scanner(System.in);
        int configuration = sc.nextInt();

        if(configuration == 1){
            InvoiceService invoiceService = new InvoiceService();
            invoiceService.createInvoice(invoice);
            AddOne();
        }else if( configuration == 2) {
            InvoiceServiceMichel invoiceServiceMichel = new InvoiceServiceMichel();
            invoiceServiceMichel.createInvoice(invoice);
            AddOne();
        }else{
            System.out.println("wrong choice, please try again");
            choiceInvoiceConfiguration(invoice);
        }
    }

    public static void AddOne(){
        System.out.println(" Add one more invoice? Y/N");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine();

        if(response.equalsIgnoreCase("y")){
            addInvoice();
        }else if( response.equalsIgnoreCase("n")) {
            System.out.println("Ok thank!");
        }else{
            System.out.println("wrong choice, please try again");
            AddOne();
        }
    }
}
