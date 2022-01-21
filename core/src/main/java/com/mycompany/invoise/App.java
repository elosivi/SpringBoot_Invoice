package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        InvoiceControllerInterface invoiceControllerInterface =  context.getBean(InvoiceControllerInterface.class); //id ou polymorphisme classe de hierarchie d'héritage notemment l'interface qui implémente le contrat
        invoiceControllerInterface.createInvoice();

    }

}
