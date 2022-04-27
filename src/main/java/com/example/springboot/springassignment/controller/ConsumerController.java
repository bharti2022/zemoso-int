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
import java.util.logging.Logger;

@Controller
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    private Logger logger= Logger.getLogger(ConsumerController.class.getName());
    public ConsumerController(){

    }
    String pathOfList="/consumers/list-consumers";
    public ConsumerController(ConsumerService consumerService){
        this.consumerService=consumerService;
    }

    @GetMapping("/list")
    public String listConsumers(Model theModel){
        List<Consumers> theConsumers = consumerService.findAll();
        theModel.addAttribute("consumers",theConsumers);
        return pathOfList;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Consumers theConsumers = new Consumers();

            theModel.addAttribute("consumers", theConsumers);

        return "/consumers/consumer-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("consumers") Consumers consumers, BindingResult bindingResult) {

          if(bindingResult.hasErrors()){

              logger.info(bindingResult.toString());
              return "redirect:/consumers/showFormForUpdate?consumerId="+consumers.getId();
          }
        else {

              logger.info(bindingResult.toString());
              consumerService.save(consumers);
              return "redirect:/consumers/list";
          }

          }



    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("consumerId") int theId,
                                    Model theModel) {
        Consumers consumers = consumerService.findById(theId);
        theModel.addAttribute("consumers", consumers);

        return "/consumers/consumer-update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("consumerId") int theId){
        Consumers consumers = consumerService.findById(theId);
        return "redirect:/consumers/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("consumerName") String theName,
                         Model theModel) {


        List<Consumers> consumers = consumerService.searchByName(theName);

        if(consumers==null){

            return pathOfList;
        }
        else {

            theModel.addAttribute("consumers", consumers);


            return pathOfList;
        }


    }


}
