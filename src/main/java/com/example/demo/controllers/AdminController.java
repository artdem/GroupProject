package com.example.demo.controllers;

import com.example.demo.entity.Forwarder;
import com.example.demo.models.SupplierDTO;
import com.example.demo.services.LackService;
import com.example.demo.entity.Purchaser;
import com.example.demo.models.ForwarderDTO;
import com.example.demo.models.PurchaserDTO;
import com.example.demo.services.ForwarderService;
import com.example.demo.services.PurchaserService;
import com.example.demo.services.SupplierService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController{

    private final PurchaserService purchaserService;
    private final ForwarderService forwarderService;
    private final SupplierService supplierService;
    private final LackService lackService;

    public AdminController(PurchaserService purchaserService, ForwarderService forwarderService, LackService lackService,
                           SupplierService supplierService) {
        this.purchaserService = purchaserService;
        this.forwarderService = forwarderService;
        this.supplierService = supplierService;
        this.lackService = lackService;
    }

    @GetMapping()
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin");
        return modelAndView;
    }

    @GetMapping("/purchasers")
    public ModelAndView purchaserList() {
        ModelAndView modelAndView = new ModelAndView("/admin/purchasers");
        modelAndView.addObject("purchasers", purchaserService.getAll());
        return modelAndView;
    }

    @GetMapping("/purchasers/add")
    public ModelAndView addPurchaserForm(PurchaserDTO purchaser){
        ModelAndView modelAndView = new ModelAndView("/admin/purchaser_add");
        modelAndView.addObject("purchaser", purchaser);
        modelAndView.addObject("purchasers", purchaserService.getAll());
        return modelAndView;
    }

    @PostMapping("/purchasers/add")
    public ModelAndView savePurchaser(@Valid @ModelAttribute("purchaser") PurchaserDTO purchaser, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/purchaser_add_success");
        modelAndViewOK.addObject("purchaser", purchaser);

        ModelAndView modelAndViewError = new ModelAndView("/admin/purchaser_add");
        modelAndViewError.addObject("purchaser", purchaser);
        modelAndViewError.addObject("purchasers", purchaserService.getAll());


        if(br.hasErrors()){
            return modelAndViewError;
        }
        purchaserService.save(purchaser);
        return modelAndViewOK;
    }

    @GetMapping("/purchasers/delete")
    public ModelAndView deletePurchaserForm(Purchaser purchaser){
        ModelAndView modelAndView = new ModelAndView("/admin/purchaser_delete");
        modelAndView.addObject("purchaser", purchaser);
        modelAndView.addObject("purchasers", purchaserService.getAll());
        return modelAndView;
    }

    @PostMapping("/purchasers/delete")
    public ModelAndView deletePurchaser(@ModelAttribute("purchaser") Purchaser purchaser){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/purchaser_delete_success");
        modelAndViewOK.addObject("purchaser", purchaser.getPurchaserID());
        purchaserService.delete(purchaser);
        return modelAndViewOK;
    }

    @GetMapping("/forwarders")
    public ModelAndView forwardersList() {
        ModelAndView modelAndView = new ModelAndView("/admin/forwarders");
        modelAndView.addObject("forwarders", forwarderService.getAll());
        return modelAndView;
    }

    @GetMapping("/forwarders/add")
    public ModelAndView addForwarderForm(ForwarderDTO forwarder){
        ModelAndView modelAndView = new ModelAndView("/admin/forwarder_add");
        modelAndView.addObject("forwarder", forwarder);
        modelAndView.addObject("forwarders", forwarderService.getAll());
        return modelAndView;
    }

    @PostMapping("/forwarders/add")
    public ModelAndView saveForwarder(@Valid @ModelAttribute("forwarder") ForwarderDTO forwarder, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/forwarder_add_success");
        modelAndViewOK.addObject("forwarder", forwarder);

        ModelAndView modelAndViewError = new ModelAndView("/admin/forwarder_add");
        modelAndViewError.addObject("forwarder", forwarder);
        modelAndViewError.addObject("forwarders", forwarderService.getAll());

        if(br.hasErrors()){
            return modelAndViewError;
        }
        forwarderService.save(forwarder);
        return modelAndViewOK;
    }

    @GetMapping("/forwarders/delete")
    public ModelAndView deleteForwarderForm(Forwarder forwarder){
        ModelAndView modelAndView = new ModelAndView("/admin/forwarder_delete");
        modelAndView.addObject("forwarder", forwarder);
        modelAndView.addObject("forwarders", forwarderService.getAll());
        return modelAndView;
    }

    @PostMapping("/forwarders/delete")
    public ModelAndView deleteForwarder(@ModelAttribute("forwarder") Forwarder forwarder){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/forwarder_delete_success");
        modelAndViewOK.addObject("forwarder", forwarder.getForwarderID());
        forwarderService.delete(forwarder);
        return modelAndViewOK;
    }

    @GetMapping("/lacks")
    public ModelAndView adminLacks() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin_lacks");
        return modelAndView;
    }

    @GetMapping("/lacks/forwarder")
    public ModelAndView lacksForwarderForm(ForwarderDTO forwarder){
        ModelAndView modelAndView = new ModelAndView("/admin/admin_lack_forwarder_form");
        modelAndView.addObject("forwarder", forwarder);
        modelAndView.addObject("forwarders", forwarderService.getAll());
        return modelAndView;
    }

    @PostMapping("/lacks/forwarder")
    public ModelAndView lacksForwarderList(@ModelAttribute("lack") ForwarderDTO forwarder){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/admin_lack_forwarder_list");
        modelAndViewOK.addObject("lacks", lackService.getForwarderLacks(forwarder));
        return modelAndViewOK;
    }

    @GetMapping("/lacks/purchaser")
    public ModelAndView lacksPurchaserForm(PurchaserDTO purchaser){
        ModelAndView modelAndView = new ModelAndView("/admin/admin_lack_purchaser_form");
        modelAndView.addObject("purchaser", purchaser);
        modelAndView.addObject("purchasers", purchaserService.getAll());
        return modelAndView;
    }

    @PostMapping("/lacks/purchaser")
    public ModelAndView lacksPurchaserList(@ModelAttribute("lacks") PurchaserDTO purchaser){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/admin_lack_purchaser_list");
        modelAndViewOK.addObject("lacks", lackService.getPurchaserLacks(purchaser));
        return modelAndViewOK;
    }

    @GetMapping("/lacks/supplier")
    public ModelAndView lacksSuplierForm(SupplierDTO supplier){
        ModelAndView modelAndView = new ModelAndView("/admin/admin_lack_supplier_form");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("suppliers", supplierService.getAll());
        return modelAndView;
    }

    @PostMapping("/lacks/supplier")
    public ModelAndView lacksSuplierList(@ModelAttribute("lacks") SupplierDTO supplier){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/admin_lack_supplier_list");
        modelAndViewOK.addObject("lacks", lackService.getSupplierLacks(supplier));
        return modelAndViewOK;
    }


}

