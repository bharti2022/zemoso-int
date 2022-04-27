package com.example.springboot.springassignment.controller;

import com.example.springboot.springassignment.entity.Consumers;
import com.example.springboot.springassignment.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    public ConsumerController(){

    }
    private static final String PATH_FOR_LIST="/consumers/list-consumers";
    private static final String REDIRECT="redirect:";
    private static final String LIST="/consumers/list";

    private String models="consumers";

    Consumers theConsumers=null;
    List<Consumers> consumers;
    public ConsumerController(ConsumerService consumerService){
        this.consumerService=consumerService;
    }

    @GetMapping("/list")
    public String listConsumers(Model theModel){
        consumers = consumerService.findAll();
        theModel.addAttribute(models,theConsumers);
        return PATH_FOR_LIST;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
         theConsumers = new Consumers();

            theModel.addAttribute(models, theConsumers);

        return "/consumers/consumer-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("consumers") Consumers consumers, BindingResult bindingResult) {

          if(bindingResult.hasErrors()){

              return "redirect:/consumers/showFormForUpdate?consumerId="+consumers.getId();
          }
        else {

              consumerService.save(consumers);
              return REDIRECT+LIST;
          }

          }



    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("consumerId") int theId,
                                    Model theModel) {
         theConsumers= consumerService.findById(theId);
        theModel.addAttribute(models, theConsumers);

        return "/consumers/consumer-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("consumerId") int theId){
         theConsumers = consumerService.findById(theId);
         consumerService.deleteById(theConsumers.getId());
        return REDIRECT+LIST;
    }
    @GetMapping("/search")
    public String search(@RequestParam("consumerName") String theName,
                         Model theModel) {


        consumers = consumerService.searchByName(theName);

            theModel.addAttribute(models, consumers);

            return PATH_FOR_LIST;

    }


}
