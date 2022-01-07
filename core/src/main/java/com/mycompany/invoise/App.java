package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceController;
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


        System.out.println(" What is your configuration? 1 ou 2 ?");
        Scanner sc = new Scanner(System.in);
        int configuration = sc.nextInt();

        if(configuration == 1){
            //injection des dépendances
            InvoiceController invoiceController = new InvoiceController();
            InvoiceService invoiceService = new InvoiceService();
            invoiceController.setInvoiceService(invoiceService); // injection de invoiceService dans le controller
            InvoiceRepository invoiceRepository = new InvoiceRepository();
            invoiceService.setInvoiceRepository(invoiceRepository); // injection du repo dans le service

            invoiceController.createInvoice();

        }else if( configuration == 2) {
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();
            InvoiceServiceMichel invoiceServiceMichel= new InvoiceServiceMichel();
            invoiceControllerMichel.setInvoiceService(invoiceServiceMichel); // injection de invoiceServiceMichel dans le controller
            InvoiceRepositoryMichel invoiceRepositoryMichel = new InvoiceRepositoryMichel();
            invoiceServiceMichel.setInvoiceRepositoryMichel(invoiceRepositoryMichel); //Injection du repoMichel dans le service

            invoiceControllerMichel.createInvoice();

        }else{
            System.out.println("wrong choice, please try again");
            choiceInvoiceConfiguration();
        }
    }

}
