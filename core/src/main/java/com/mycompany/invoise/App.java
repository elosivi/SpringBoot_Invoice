package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.controller.InvoiceControllerKeyboard;
import com.mycompany.invoise.controller.InvoiceControllerDouchette;
import com.mycompany.invoise.controller.InvoiceControllerWeb;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.repository.InvoiceRepositoryMemory;
import com.mycompany.invoise.repository.InvoiceRepositoryDatabase;
import com.mycompany.invoise.service.InvoiceServiceInterface;
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

        Scanner sc = new Scanner(System.in);

        System.out.println(" Type de controller ? keyboard: k /web: w / douchette: d");
        String controllerType = sc.nextLine();

        System.out.println(" Type de service ? number : n / prefix : p ");
        String serviceType = sc.nextLine();

        System.out.println(" Type de repository ? memory :m / database : d ");
        String repositoryType = sc.nextLine();

        InvoiceControllerInterface invoiceController = null;
        switch (controllerType){
            case "k" :
                invoiceController = new InvoiceControllerKeyboard();
                break;
            case "w" :
                invoiceController = new InvoiceControllerWeb();
                break;
            case "d" :
                invoiceController = new InvoiceControllerDouchette();
                break;
        }

        InvoiceServiceInterface invoiceService = null;
        switch (serviceType){
            case "n" :
                invoiceService = new InvoiceServiceNumber();
                break;
            case "p" :
                invoiceService = new InvoiceServicePrefix();
                break;
        }

        InvoiceRepositoryInterface invoiceRepository = null;
        switch(repositoryType){
            case "m" :
                invoiceRepository = new InvoiceRepositoryMemory();
                break;
            case "d" :
                invoiceRepository = new InvoiceRepositoryDatabase();
                break;
        }

        //injection dependance
        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);

        invoiceController.createInvoice();

    }

}
