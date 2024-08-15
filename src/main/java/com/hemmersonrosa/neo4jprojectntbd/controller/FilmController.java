package com.hemmersonrosa.neo4jprojectntbd.controller;

import com.hemmersonrosa.neo4jprojectntbd.entity.Film;
import com.hemmersonrosa.neo4jprojectntbd.repository.FilmRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("film")
public class FilmController {

    @Autowired
    private FilmRepository repository;

    @GetMapping("/form")
    public ModelAndView form(Film film, ModelMap model) {
        model.addAttribute("film", film);
        return new ModelAndView("film/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("film", repository.findAll());
        return new ModelAndView("film/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("film") Film film) {
        repository.save(film);
        return new ModelAndView("redirect:/film/list");
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit( @PathVariable Long id, ModelMap model){
        model.addAttribute("film", repository.findById(id));
        return new ModelAndView("/film/form_edit", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("film") Film film){
        repository.save(film);
        return new ModelAndView("redirect:/film/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id){
        repository.deleteById(id);
        return new ModelAndView("redirect:/film/list");
    }

}
