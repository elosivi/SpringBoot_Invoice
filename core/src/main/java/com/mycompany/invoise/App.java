package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import com.mycompany.invoise.service.prefix.InvoiceServicePrefix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        ApplicationContext context = SpringApplication.run(App.class);
        InvoiceControllerInterface invoiceControllerInterface = context.getBean(InvoiceControllerInterface.class); //id ou polymorphisme classe de hierarchie d'héritage notemment l'interface qui implémente le contrat
        invoiceControllerInterface.createInvoice();

    }

    @Bean
    public InvoiceServiceInterface configureInvoiceService() {
        return new InvoiceServicePrefix();
    }

}
