package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceController;
import com.mycompany.invoise.controller.InvoiceControllerMichel;
import com.mycompany.invoise.entity.Invoice;


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
            InvoiceController invoiceController = new InvoiceController();
            InvoiceController.addInvoiceUsingConsole();

        }else if( configuration == 2) {
            InvoiceControllerMichel invoiceControllerMichel = new InvoiceControllerMichel();
            InvoiceControllerMichel.addInvoiceUsingWeb();
        }else{
            System.out.println("wrong choice, please try again");
            choiceInvoiceConfiguration();
        }
    }

}
