package com.example.Gestion.d.une.ecole.de.musique.Controller;

import org.springframework.ui.Model;
import com.example.Gestion.d.une.ecole.de.musique.Service.InstrumentService;
import com.example.Gestion.d.une.ecole.de.musique.entity.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @GetMapping
    public String listeInstruments(@RequestParam(required = false) String famille,
                                   @RequestParam(required = false) Boolean disponibilite,
                                   Model model) {
        model.addAttribute("instruments", instrumentService.filtrer(famille, disponibilite));
        model.addAttribute("famille", famille);
        model.addAttribute("disponibilite", disponibilite);
        return "instrument/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("instrument", new Instrument());
        return "instrument/form";
    }

    @PostMapping("/save")
    public String saveInstrument(@ModelAttribute Instrument instrument) {
        instrumentService.save(instrument);
        return "redirect:/instruments";
    }

    @GetMapping("/edit/{id}")
    public String editInstrument(@PathVariable Long id, Model model) {
        model.addAttribute("instrument", instrumentService.getById(id));
        return "instrument/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstrument(@PathVariable Long id) {
        instrumentService.delete(id);
        return "redirect:/instruments";
    }
}