package com.example.demo.controllers;

import com.example.demo.entity.Supplier;
import com.example.demo.models.*;
import com.example.demo.services.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController{

    private final UserService userService;
    private final SupplierService supplierService;
    private final LackService lackService;

    public AdminController(UserService userService, LackService lackService,
                           SupplierService supplierService) {
        this.userService = userService;
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
        modelAndView.addObject("purchasers", userService.getAllByRole(Role.ROLE_PURCHASER));
        return modelAndView;
    }

    @GetMapping("/purchasers/add")
    public ModelAndView addPurchaserForm(UserDTO purchaser){
        ModelAndView modelAndView = new ModelAndView("/admin/purchaser_add");
        modelAndView.addObject("purchaser", purchaser);
        return modelAndView;
    }

    @PostMapping("/purchasers/add")
    public ModelAndView savePurchaser(@Valid @ModelAttribute("purchaser") UserDTO purchaser, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/purchaser_add_success");
        modelAndViewOK.addObject("purchaser", purchaser);

        ModelAndView modelAndViewError = new ModelAndView("/admin/purchaser_add");
        modelAndViewError.addObject("purchaser", purchaser);

        if(br.hasErrors()){
            return modelAndViewError;
        }
        userService.saveUser(purchaser, Role.ROLE_PURCHASER.toString());
        return modelAndViewOK;
    }

    @GetMapping("/purchasers/delete")
    public ModelAndView deletePurchaserForm(UserDTO purchaser){
        ModelAndView modelAndView = new ModelAndView("/admin/purchaser_delete");
        modelAndView.addObject("purchaser", purchaser);
        modelAndView.addObject("purchasers", userService.getAllByRole(Role.ROLE_PURCHASER));
        return modelAndView;
    }

    @PostMapping("/purchasers/delete")
    public ModelAndView deletePurchaser(@ModelAttribute("purchaser") UserDTO purchaser){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/purchaser_delete_success");
        modelAndViewOK.addObject("purchaser", purchaser.getUserID());
        userService.deleteUser(purchaser);
        return modelAndViewOK;
    }

    @GetMapping("/forwarders")
    public ModelAndView forwardersList() {
        ModelAndView modelAndView = new ModelAndView("/admin/forwarders");
        modelAndView.addObject("forwarders", userService.getAllByRole(Role.ROLE_FORWARDER));
        return modelAndView;
    }

    @GetMapping("/forwarders/add")
    public ModelAndView addForwarderForm(UserDTO forwarder){
        ModelAndView modelAndView = new ModelAndView("/admin/forwarder_add");
        modelAndView.addObject("forwarder", forwarder);
        return modelAndView;
    }

    @PostMapping("/forwarders/add")
    public ModelAndView saveForwarder(@Valid @ModelAttribute("forwarder") UserDTO forwarder, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/forwarder_add_success");
        modelAndViewOK.addObject("forwarder", forwarder);

        ModelAndView modelAndViewError = new ModelAndView("/admin/forwarder_add");
        modelAndViewError.addObject("forwarder", forwarder);

        if(br.hasErrors()){
            return modelAndViewError;
        }
        userService.saveUser(forwarder, Role.ROLE_FORWARDER.toString());
        return modelAndViewOK;
    }

    @GetMapping("/forwarders/delete")
    public ModelAndView deleteForwarderForm(UserDTO forwarder){
        ModelAndView modelAndView = new ModelAndView("/admin/forwarder_delete");
        modelAndView.addObject("forwarder", forwarder);
        modelAndView.addObject("forwarders", userService.getAllByRole(Role.ROLE_FORWARDER));
        return modelAndView;
    }

    @PostMapping("/forwarders/delete")
    public ModelAndView deleteForwarder(@ModelAttribute("forwarder") UserDTO forwarder){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/forwarder_delete_success");
        modelAndViewOK.addObject("forwarder", forwarder.getUserID());
        userService.deleteUser(forwarder);
        return modelAndViewOK;
    }

    @GetMapping("/suppliers")
    public ModelAndView supplier() {
        ModelAndView modelAndView = new ModelAndView("/admin/suppliers");
        modelAndView.addObject("suppliers", supplierService.getAll());
        return modelAndView;
    }

    @GetMapping("/suppliers/add")
    public ModelAndView addForm(SupplierDTO supplier){
        ModelAndView modelAndView = new ModelAndView("/admin/supplier_add");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("purchasers", userService.getAllByRole(Role.ROLE_PURCHASER));
        return modelAndView;
    }

    @PostMapping("/suppliers/add")
    public ModelAndView save(@Valid @ModelAttribute("supplier") SupplierDTO supplier, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/supplier_add_success");
        modelAndViewOK.addObject("supplier", supplier);

        ModelAndView modelAndViewError = new ModelAndView("/admin/supplier_add");
        modelAndViewError.addObject("supplier", supplier);
        modelAndViewError.addObject("purchasers", userService.getAllByRole(Role.ROLE_PURCHASER));

        if(br.hasErrors()){
            return modelAndViewError;
        }
        supplierService.save(supplier);
        return modelAndViewOK;
    }
    @GetMapping("/suppliers/delete")
    public ModelAndView deleteForm(Supplier supplier){
        ModelAndView modelAndView = new ModelAndView("/admin/supplier_delete");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("suppliers", supplierService.getAll());
        return modelAndView;
    }

    @PostMapping("/suppliers/delete")
    public ModelAndView delete(@ModelAttribute("supplier") Supplier supplier){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/supplier_delete_success");
        modelAndViewOK.addObject("supplier", supplier.getSupplierID());
        supplierService.delete(supplier);
        return modelAndViewOK;
    }


    @GetMapping("/lacks")
    public ModelAndView adminLacks() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin_lacks");
        return modelAndView;
    }

    @GetMapping("/lacks/lacks")
    public ModelAndView lacksList(){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/admin_lacks_list");
        modelAndViewOK.addObject("lacks", lackService.getAllLacks());
        return modelAndViewOK;
    }

    @GetMapping("/lacks/forwarder")
    public ModelAndView lacksForwarderForm(UserDTO forwarder){
        ModelAndView modelAndView = new ModelAndView("/admin/admin_lack_forwarder_form");
        modelAndView.addObject("forwarder", forwarder);
        modelAndView.addObject("forwarders", userService.getAllByRole(Role.ROLE_FORWARDER));
        return modelAndView;
    }

    @PostMapping("/lacks/forwarder")
    public ModelAndView lacksForwarderList(@ModelAttribute("lack") UserDTO forwarder){
        ModelAndView modelAndViewOK = new ModelAndView("/admin/admin_lack_forwarder_list");
        modelAndViewOK.addObject("lacks", lackService.getForwarderLacks(forwarder));
        return modelAndViewOK;
    }

    @GetMapping("/lacks/purchaser")
    public ModelAndView lacksPurchaserForm(UserDTO purchaser){
        ModelAndView modelAndView = new ModelAndView("/admin/admin_lack_purchaser_form");
        modelAndView.addObject("purchaser", purchaser);
        modelAndView.addObject("purchasers", userService.getAllByRole(Role.ROLE_PURCHASER));
        return modelAndView;
    }

    @PostMapping("/lacks/purchaser")
    public ModelAndView lacksPurchaserList(@ModelAttribute("lacks") UserDTO purchaser){
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

