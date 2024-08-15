package com.hemmersonrosa.neo4jprojectntbd.controller;

import com.hemmersonrosa.neo4jprojectntbd.entity.Language;
import com.hemmersonrosa.neo4jprojectntbd.repository.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Transactional
@Controller
@RequestMapping("language")
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/form")
    public ModelAndView form(Language language, ModelMap model) {
        model.addAttribute("language", language);
        return new ModelAndView("language/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("language", languageRepository.findAll());
        return new ModelAndView("language/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("language") Language language) {
        languageRepository.save(language);
        return new ModelAndView("redirect:/language/list");
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit( @PathVariable Long id, ModelMap model){
        model.addAttribute("language", languageRepository.findById(id));
        return new ModelAndView("/language/form_edit", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("language") Language language){
        languageRepository.save(language);
        return new ModelAndView("redirect:/language/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Long id){
        languageRepository.deleteById(id);
        return new ModelAndView("redirect:/language/list");
    }

}
