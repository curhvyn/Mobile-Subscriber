package com.example.Mobile.Subscriber.controller;

import com.example.Mobile.Subscriber.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/2")
    public String viewHomePage(Model model){
        model.addAttribute("listOwners", ownerService.getAllOwners());
        return "list_subscribers";
    }
}
