package com.example.demo.controllers;

import com.example.demo.models.LackDTO;
import com.example.demo.services.LackService;
import com.example.demo.services.SupplierService;
import com.example.demo.services.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/forwarder")
public class ForwarderController{

    private final LackService lackService;
    private final UserService userService;
    private final SupplierService supplierService;

    public ForwarderController(LackService lackService, UserService userService, SupplierService supplierService) {
        this.lackService = lackService;
        this.userService = userService;
        this.supplierService = supplierService;
    }

    @GetMapping()
    public ModelAndView forwarder() {
        ModelAndView modelAndView = new ModelAndView("/forwarder/forwarder");
        return modelAndView;
    }

    @GetMapping("/lacks")
    public ModelAndView forwarderLacksList(LackDTO lack){
        ModelAndView modelAndView = new ModelAndView("/forwarder/forwarder_lacks_list");
        modelAndView.addObject("lacks", lackService
                .getForwarderLacks(userService.findByID(1L)));
        return modelAndView;
    }

    @GetMapping("/lacks/add")
    public ModelAndView lacksForwarderList(LackDTO lack){
        ModelAndView modelAndView = new ModelAndView("/forwarder/forwarder_lack_add");
        modelAndView.addObject("lack", lack);
        modelAndView.addObject("suppliers", supplierService.getAll());
        return modelAndView;
    }

    @PostMapping("/lacks/add")
    public ModelAndView lackUpdateSuccess(@Valid @ModelAttribute("lack") LackDTO lack, BindingResult br){
        ModelAndView modelAndViewOK = new ModelAndView("/forwarder/forwarder_lack_add_success");
        modelAndViewOK.addObject("lack", lack);

        ModelAndView modelAndViewError = new ModelAndView("/forwarder/forwarder_lack_add");
        modelAndViewError.addObject("lack", lack);
        modelAndViewError.addObject("suppliers", supplierService.getAll());

        if(br.hasErrors()){
            return modelAndViewError;
        }

        userService.saveLack(lack);
        return modelAndViewOK;
    }

    @GetMapping("/lacks/delete")
    public ModelAndView deleteForm(LackDTO lack){
        ModelAndView modelAndView = new ModelAndView("/forwarder/forwarder_lack_delete");
        modelAndView.addObject("lack", lack);
        modelAndView.addObject("lacks", lackService
                .getForwarderLacks(userService.findByID(72036854775807L)));
        return modelAndView;
    }

    @PostMapping("/lacks/delete")
    public ModelAndView user(@RequestParam("idChecked") List<Long> idUsers){
        ModelAndView modelAndView = new ModelAndView("/forwarder/forwarder_lack_delete_success");
        modelAndView.addObject("lista", lackService.delete(idUsers));
        return modelAndView;
    }


}


