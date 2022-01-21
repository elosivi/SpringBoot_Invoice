package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import com.mycompany.invoise.service.prefix.InvoiceServicePrefix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages = {
        "com.mycompany.invoise.controller.web",
        "com.mycompany.invoise.repository.database",
        /*"com.mycompany.invoise.service.prefix"*/})
@PropertySource("classpath:application.properties")
public class App 
{
    public static void main(String[] args)
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        InvoiceControllerInterface invoiceControllerInterface =  context.getBean(InvoiceControllerInterface.class); //id ou polymorphisme classe de hierarchie d'héritage notemment l'interface qui implémente le contrat
        invoiceControllerInterface.createInvoice();

    }
    @Bean
    public InvoiceServiceInterface configureInvoiceService(){
        return new InvoiceServicePrefix();
    }

}
