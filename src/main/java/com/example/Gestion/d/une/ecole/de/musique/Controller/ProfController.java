package com.example.Gestion.d.une.ecole.de.musique.Controller;

import com.example.Gestion.d.une.ecole.de.musique.Service.ProfService;
import com.example.Gestion.d.une.ecole.de.musique.entity.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profs")
public class ProfController {

    @Autowired
    private ProfService profService;

    @GetMapping
    public String listeProfs(Model model) {
        model.addAttribute("profs", profService.getAll());
        return "prof/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("prof", new Prof());
        return "prof/form";
    }

    @PostMapping("/save")
    public String saveProf(@ModelAttribute Prof prof) {
        profService.save(prof);
        return "redirect:/profs";
    }

    @GetMapping("/edit/{id}")
    public String editProf(@PathVariable Long id, Model model) {
        model.addAttribute("prof", profService.getById(id));
        return "prof/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProf(@PathVariable Long id) {
        profService.delete(id);
        return "redirect:/profs";
    }
}
