package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceController;
import com.mycompany.invoise.controller.InvoiceControllerChambouleToutMagasin2;
import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.controller.InvoiceControllerMichel;
import com.mycompany.invoise.repository.InvoiceRepository;
import com.mycompany.invoise.repository.InvoiceRepositoryMichel;
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
        choiceInvoiceConfiguration();

    }

    public static void choiceInvoiceConfiguration(){


        System.out.println(" What is your configuration? 1(console) / 2 (web) / 3(web+ normal num invoice) / 4 (shower) ?");
        Scanner sc = new Scanner(System.in);
        int configuration = sc.nextInt();

        if(configuration == 1){
            //injection des dépendances
            InvoiceController invoiceController = new InvoiceController(); //via console
            InvoiceService invoiceService = new InvoiceService();
            invoiceController.setInvoiceService(invoiceService); // injection de invoiceService dans le controller
            InvoiceRepository invoiceRepository = new InvoiceRepository();
            invoiceService.setInvoiceRepository(invoiceRepository); // injection du repo dans le service

            invoiceController.createInvoice();

        }else if( configuration == 2) {
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel(); // via web
            InvoiceServiceMichel invoiceServiceMichel= new InvoiceServiceMichel();
            invoiceControllerMichel.setInvoiceService(invoiceServiceMichel); // injection de invoiceServiceMichel dans le controller
            InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();
            invoiceServiceMichel.setInvoiceRepositoryMichel(invoiceRepositoryMichel); //Injection du repoMichel dans le service

            invoiceControllerMichel.createInvoice();

        }else if( configuration == 3) {
            InvoiceControllerMichel invoiceControllerChamboulleTout1 = new InvoiceControllerMichel(); //via web
            InvoiceService invoiceService = new InvoiceService();
            invoiceControllerChamboulleTout1.setInvoiceService(invoiceService); // injection de invoiceService avec numerotation normale des invoices dans le controller
            InvoiceRepositoryMichel invoiceRepositoryChamboulleTout1 = new InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepositoryChamboulleTout1); //Injection du repoMichel dans le service

            invoiceControllerChamboulleTout1.createInvoice();

        }else if( configuration == 4) {
            InvoiceControllerChambouleToutMagasin2 invoiceControllerChambouleToutMagasin2 = new InvoiceControllerChambouleToutMagasin2(); //via scan code by shower
            InvoiceService invoiceService = new InvoiceService();
            invoiceControllerChambouleToutMagasin2.setInvoiceService(invoiceService); // injection de invoiceService avec numerotation normale des invoices dans le controller
            InvoiceRepositoryMichel invoiceRepositoryChamboulleTout1 = new InvoiceRepositoryMichel();
            invoiceService.setInvoiceRepository(invoiceRepositoryChamboulleTout1); //Injection du repoMichel dans le service

            invoiceControllerChambouleToutMagasin2.createInvoice();
        }else{
            System.out.println("wrong choice, please try again");
            choiceInvoiceConfiguration();
        }
    }

}
