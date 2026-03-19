package com.example.Gestion.d.une.ecole.de.musique.Controller;

import com.example.Gestion.d.une.ecole.de.musique.Service.CoursService;
import com.example.Gestion.d.une.ecole.de.musique.Service.ProfService;
import com.example.Gestion.d.une.ecole.de.musique.entity.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @Autowired
    private ProfService profService;

    @GetMapping
    public String listeCours(@RequestParam(required = false) String niveau,
                             @RequestParam(required = false) String jour,
                             Model model) {
        model.addAttribute("coursList", coursService.filtrer(niveau, jour));
        model.addAttribute("niveau", niveau);
        model.addAttribute("jour", jour);
        return "cours/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("cours", new Cours());
        model.addAttribute("profs", profService.getAll());
        return "cours/form";
    }

    @PostMapping("/save")
    public String saveCours(@ModelAttribute Cours cours) {
        coursService.save(cours);
        return "redirect:/cours";
    }

    @GetMapping("/edit/{id}")
    public String editCours(@PathVariable Long id, Model model) {
        model.addAttribute("cours", coursService.getById(id));
        model.addAttribute("profs", profService.getAll());
        return "cours/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.delete(id);
        return "redirect:/cours";
    }
}