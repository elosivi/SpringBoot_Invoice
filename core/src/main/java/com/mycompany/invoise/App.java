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

        System.out.println(" Quelles est la classe controller souhaitée ? \n " +
                "keyboard: com.mycompany.invoise.controller.InvoiceControllerKeyboard /web: com.mycompany.invoise.controller.InvoiceControllerWeb / douchette: com.mycompany.invoise.controller.InvoiceControllerDouchette");
        String controllerClass = sc.nextLine();

        System.out.println(" Quelles est la classe service souhaitée ? \n " +
                "number : com.mycompany.invoise.service.InvoiceServiceNumber / prefix : com.mycompany.invoise.service.InvoiceServicePrefix ");
        String serviceClass = sc.nextLine();

        System.out.println(" Quelles est la classe repository souhaitée ? \n" +
                "memory :com.mycompany.invoise.repository.InvoiceRepositoryMemory  / database :com.mycompany.invoise.repository.InvoiceRepositoryDatabase  ");
        String repositoryClass = sc.nextLine();

        InvoiceControllerInterface invoiceController = null;
        InvoiceServiceInterface invoiceService = null;
        InvoiceRepositoryInterface invoiceRepository = null;

        //injection dependance
        // reflexivité avec java : spring instabcie un objet sur la base d'un nom de classe donné par le user
        // ex instanciation d'un controller qui retournera un objet InvoiceControllerInterface
        //forName peut générer des exception -> try catch

        try{
            invoiceController=(InvoiceControllerInterface)Class.forName(controllerClass).getDeclaredConstructor().newInstance();
            invoiceService= (InvoiceServiceInterface)Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepository= (InvoiceRepositoryInterface)Class.forName(repositoryClass).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }


        invoiceController.setInvoiceService(invoiceService);
        invoiceService.setInvoiceRepository(invoiceRepository);

        invoiceController.createInvoice();

    }

}
