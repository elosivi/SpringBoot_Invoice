package com.mycompany.invoise.invoiseweb.api;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.invoiseweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResources {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){
        System.out.println("la méthode create a été invoquée");
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> list(){
        System.out.println("La méthode list() a été invoquée");
        return invoiceService.getInvoiceList();
    }

    @GetMapping("/{id}")
    public Invoice get (@PathVariable("id")String number, Model model){ // nb: Model model always must be the last one param, at the end
        System.out.println("La méthode get a été invoquée");
        return invoiceService.getInvoiceByNumber(number);
    }


}
