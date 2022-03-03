package com.example.Mobile.Subscriber.controller;

import com.example.Mobile.Subscriber.DTO.SubscriberDTO;
import com.example.Mobile.Subscriber.enums.ServiceType;
import com.example.Mobile.Subscriber.model.Subscriber;
import com.example.Mobile.Subscriber.repository.SubscriberRepository;
import com.example.Mobile.Subscriber.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubscriberController {

    @Autowired
    SubscriberRepository subscriberRepository;
    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/")
    public String home(Model model){
        long va1 = subscriberRepository.countByServiceType(ServiceType.MOBILE_POSTPAID);
        long va2 = subscriberRepository.countByServiceType(ServiceType.MOBILE_PREPAID);
        long total = va1 + va2;
        model.addAttribute("postPaid", va1);
        model.addAttribute("prePaid", va2);
        model.addAttribute("total", total);
        return "index";
    }

    @GetMapping("/list_subscribers")
    public String viewHomePage(Model model, String keyword){
        List<Subscriber> subscriber;
        subscriber = keyword == null? subscriberService.getAllSubscribers():subscriberService
                .findByKeyword(keyword);
        model.addAttribute("listSubscribers", subscriber);
        return "list_subscribers";
    }

    @GetMapping("/showNewSubscriberForm")
    public  String showNewSubscriberForm(Model model) {
        SubscriberDTO subscriber = new SubscriberDTO();
        model.addAttribute("subscriber", subscriber);
        return "new_subscriber";
    }

    @PostMapping("saveSubscriber")
    public  String saveSubscriber(@ModelAttribute("subscriber") SubscriberDTO subscriberDTO){
        subscriberDTO.setStartDate(System.currentTimeMillis());
        subscriberService.saveSubscriber(subscriberDTO);
        return "redirect:/list_subscribers";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        Subscriber subscriber = subscriberService.getSubscriberById(id);
        model.addAttribute("subscriber", subscriber);
        return "update_subscriber";
    }

    @GetMapping("/deleteSubscriber/{id}")
    public String deleteSubscriber(@PathVariable (value = "id") long id) {
        this.subscriberService.deleteSubscriberById(id);
        return "redirect:/list_subscribers";
    }

    @RequestMapping(path = {"/list_subscribers/search"})
    public String home(Model model, String keyword) {
        List<Subscriber> list;
        if(keyword!=null) list = subscriberService.findByKeyword(keyword);
        else {
            list = subscriberService.getAllSubscribers();
        }
        model.addAttribute("list", list);
        return "/list_subscribers";
    }
}
