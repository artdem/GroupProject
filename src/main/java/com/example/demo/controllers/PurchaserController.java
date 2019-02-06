package com.example.demo.controllers;

import com.example.demo.entity.Supplier;
import com.example.demo.models.LackDTO;
import com.example.demo.models.PurchaserDTO;
import com.example.demo.models.SupplierDTO;
import com.example.demo.services.LackService;
import com.example.demo.services.PurchaserService;
import com.example.demo.services.SupplierService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchaser")
public class PurchaserController{

    private final LackService lackService;
    private final PurchaserService purchaserService;
    private final SupplierService supplierService;

    public PurchaserController(LackService lackService, PurchaserService purchaserService, SupplierService supplierService) {
        this.lackService = lackService;
        this.purchaserService = purchaserService;
        this.supplierService = supplierService;
    }

    @GetMapping()
    public ModelAndView purchaser() {
        ModelAndView modelAndView = new ModelAndView("/purchaser/purchaser");
        return modelAndView;
    }

    @GetMapping("/suppliers")
    public ModelAndView supplier() {
        ModelAndView modelAndView = new ModelAndView("/purchaser/suppliers");
        modelAndView.addObject("suppliers", supplierService.getAll());
        return modelAndView;
    }

    @GetMapping("/suppliers/add")
    public ModelAndView addForm(SupplierDTO supplier){
        ModelAndView modelAndView = new ModelAndView("/purchaser/supplier_add");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("purchasers", purchaserService.getAll());
        return modelAndView;
    }

    @PostMapping("/suppliers/add")
    public ModelAndView save(@Valid @ModelAttribute("supplier") SupplierDTO supplier, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("/purchaser/supplier_add_success");
        modelAndViewOK.addObject("supplier", supplier);

        ModelAndView modelAndViewError = new ModelAndView("/purchaser/supplier_add");
        modelAndViewError.addObject("supplier", supplier);
        modelAndViewError.addObject("purchasers", purchaserService.getAll());

        if(br.hasErrors()){
            return modelAndViewError;
        }
        supplierService.save(supplier);
        return modelAndViewOK;
    }
    @GetMapping("/suppliers/delete")
    public ModelAndView deleteForm(Supplier supplier){
        ModelAndView modelAndView = new ModelAndView("/purchaser/supplier_delete");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("suppliers", supplierService.getAll());
        return modelAndView;
    }

    @PostMapping("/suppliers/delete")
    public ModelAndView delete(@ModelAttribute("supplier") Supplier supplier){
        ModelAndView modelAndViewOK = new ModelAndView("/purchaser/supplier_delete_success");
        modelAndViewOK.addObject("supplier", supplier.getSupplierID());
        supplierService.delete(supplier);
        return modelAndViewOK;
    }
}

