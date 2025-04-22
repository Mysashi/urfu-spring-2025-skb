package com.example.demo.controller;

import com.example.demo.TicketForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class TicketController {

    @RequestMapping(method = RequestMethod.POST, value = "tickets")
    public String validateTicket(@Valid TicketForm ticketForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ticketerror";
        }
        return "result";
    }
    @RequestMapping(method = RequestMethod.GET, value = "tickets")
    public String showForm(TicketForm ticketForm, Model model) {
        model.addAttribute("ticketForm", ticketForm);
        return "tickets";
    }

}
