package com.tssb.controllers;

import com.tssb.dao.ClientDAO;
import com.tssb.dao.PersonDAO;
import com.tssb.models.Client;
import com.tssb.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientDAO clientDAO;

    @Autowired
    public ClientController(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("clients", clientDAO.index());
        return "clients/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientDAO.show(id));
        return "clients/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("client") Client client) {
        return "clients/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("client") @Valid Client client,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "clients/new";

        clientDAO.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("client", clientDAO.show(id));
        return "clients/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("client")
                         @Valid Client client,
                         @PathVariable("id") int id ,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "clients/edit";
        clientDAO.update(id, client);
        return "redirect:/clients";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        clientDAO.delete(id);
        return "redirect:/clients";
    }

}
