package com.tssb.controllers;



import com.tssb.dao.TrainDAO;
import com.tssb.models.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/trains")
public class TrainsController {
    private TrainDAO trainDAO;

    @Autowired
    public TrainsController(TrainDAO trainDAO) {
        this.trainDAO = trainDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("trains", trainDAO.index());
        return "trains/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int trainNumber, Model model) {
        model.addAttribute("train", trainDAO.show(trainNumber));
        return "trains/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("train") Train train){
        return "trains/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("train") @Valid Train train,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "trains/new";

        trainDAO.save(train);
        return "redirect:/trains";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("train", trainDAO.show(id));
        return "trains/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("train")
                         @Valid Train train,
                         @PathVariable("id") int id,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "trains/edit";
        trainDAO.update(id, train);
        return "redirect:/trains";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        trainDAO.delete(id);
        return "redirect:/trains";
    }




}
