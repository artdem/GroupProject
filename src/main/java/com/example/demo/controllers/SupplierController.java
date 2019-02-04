package com.example.demo.controllers;

import com.example.demo.entity.Purchaser;
import com.example.demo.models.SupplierDTO;
import com.example.demo.services.PurchaserService;
import com.example.demo.services.SupplierService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/suppliers")
public class SupplierController{
    private final SupplierService supplierService;
    private final PurchaserService purchaserService;
    private SupplierController(SupplierService supplierService, PurchaserService purchaserService){
        this.supplierService = supplierService;
        this.purchaserService = purchaserService;
    }

    @GetMapping()
    public ModelAndView supplier() {
        ModelAndView modelAndView = new ModelAndView("suppliers");
        modelAndView.addObject("suppliers", supplierService.getAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView form(SupplierDTO supplier){
        ModelAndView modelAndView = new ModelAndView("supplier_add");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("purchasers", purchaserService.getAll());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView save(@Valid @ModelAttribute("supplier") SupplierDTO supplier, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("supplier-add-succes");
        modelAndViewOK.addObject("supplier", supplier);

        ModelAndView modelAndViewError = new ModelAndView("supplier_add");
        modelAndViewError.addObject("supplier", supplier);
        modelAndViewError.addObject("purchasers", purchaserService.getAll());


        if(br.hasErrors()){
            return modelAndViewError;
        }
        supplierService.save(supplier);
        return modelAndViewOK;
    }
}
