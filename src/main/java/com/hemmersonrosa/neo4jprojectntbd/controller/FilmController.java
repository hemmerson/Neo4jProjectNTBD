package com.hemmersonrosa.neo4jprojectntbd.controller;

import com.hemmersonrosa.neo4jprojectntbd.entity.Actor;
import com.hemmersonrosa.neo4jprojectntbd.repository.ActorRepository;
import com.hemmersonrosa.neo4jprojectntbd.repository.ActorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("actor")
public class ActorController {

    @Autowired
    private ActorRepository repository;

    @GetMapping("/form")
    public ModelAndView form(Actor actor, ModelMap model) {
        model.addAttribute("actor", actor);
        return new ModelAndView("actor/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("actor", repository.findAll());
        return new ModelAndView("actor/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("actor") Actor actor) {
        repository.save(actor);
        return new ModelAndView("redirect:/actor/list");
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit( @PathVariable Long id, ModelMap model){
        model.addAttribute("actor", repository.findById(id));
        return new ModelAndView("/actor/form_edit", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("actor") Actor actor){
        repository.save(actor);
        return new ModelAndView("redirect:/actor/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id){
        repository.deleteById(id);
        return new ModelAndView("redirect:/actor/list");
    }

}
