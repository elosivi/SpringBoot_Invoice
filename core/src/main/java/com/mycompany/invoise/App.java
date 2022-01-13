package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerKeyboard;
import com.mycompany.invoise.controller.InvoiceControllerDouchette;
import com.mycompany.invoise.controller.InvoiceControllerWeb;
import com.mycompany.invoise.repository.InvoiceRepositoryMemory;
import com.mycompany.invoise.repository.InvoiceRepositoryDatabase;
import com.mycompany.invoise.service.InvoiceServiceNumber;
import com.mycompany.invoise.service.InvoiceServicePrefix;

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
        choiceInvoiceConfiguration();

    }

    public static void choiceInvoiceConfiguration(){


        System.out.println(" What is your configuration? 1(console) / 2 (web) / 3(web+ normal num invoice) / 4 (shower) ?");
        Scanner sc = new Scanner(System.in);
        int configuration = sc.nextInt();

        if(configuration == 1){
            //injection des dépendances
            InvoiceControllerKeyboard invoiceController = new InvoiceControllerKeyboard(); //via console
            InvoiceServiceNumber invoiceService = new InvoiceServiceNumber();
            invoiceController.setInvoiceService(invoiceService); // injection de invoiceService dans le controller
            InvoiceRepositoryMemory invoiceRepository = new InvoiceRepositoryMemory();
            invoiceService.setInvoiceRepository(invoiceRepository); // injection du repo dans le service

            invoiceController.createInvoice();

        }else if( configuration == 2) {
            InvoiceControllerWeb invoiceControllerWeb = new InvoiceControllerWeb(); // via web
            InvoiceServicePrefix invoiceServiceMichel= new InvoiceServicePrefix();
            invoiceControllerWeb.setInvoiceService(invoiceServiceMichel); // injection de invoiceServiceMichel dans le controller
            InvoiceRepositoryDatabase invoiceRepositoryMichel = new InvoiceRepositoryDatabase();
            invoiceServiceMichel.setInvoiceRepositoryMichel(invoiceRepositoryMichel); //Injection du repoMichel dans le service

            invoiceControllerWeb.createInvoice();

        }else if( configuration == 3) {
            InvoiceControllerWeb invoiceControllerChamboulleTout1 = new InvoiceControllerWeb(); //via web
            InvoiceServiceNumber invoiceService = new InvoiceServiceNumber();
            invoiceControllerChamboulleTout1.setInvoiceService(invoiceService); // injection de invoiceService avec numerotation normale des invoices dans le controller
            InvoiceRepositoryDatabase invoiceRepositoryChamboulleTout1 = new InvoiceRepositoryDatabase();
            invoiceService.setInvoiceRepository(invoiceRepositoryChamboulleTout1); //Injection du repoMichel dans le service

            invoiceControllerChamboulleTout1.createInvoice();

        }else if( configuration == 4) {
            InvoiceControllerDouchette invoiceControllerDouchette = new InvoiceControllerDouchette(); //via scan code by shower
            InvoiceServiceNumber invoiceService = new InvoiceServiceNumber();
            invoiceControllerDouchette.setInvoiceService(invoiceService); // injection de invoiceService avec numerotation normale des invoices dans le controller
            InvoiceRepositoryDatabase invoiceRepositoryChamboulleTout1 = new InvoiceRepositoryDatabase();
            invoiceService.setInvoiceRepository(invoiceRepositoryChamboulleTout1); //Injection du repoMichel dans le service

            invoiceControllerDouchette.createInvoice();
        }else{
            System.out.println("wrong choice, please try again");
            choiceInvoiceConfiguration();
        }
    }

}
