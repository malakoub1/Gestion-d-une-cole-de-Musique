package com.example.Gestion.d.une.ecole.de.musique.Controller;

import com.example.Gestion.d.une.ecole.de.musique.Service.CoursService;
import com.example.Gestion.d.une.ecole.de.musique.Service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stats")
public class StatController {

    @Autowired
    private CoursService coursService;

    @Autowired
    private InstrumentService instrumentService;

    @GetMapping
    public String statistiques(Model model) {
        model.addAttribute("nbCoursSemaine", coursService.nombreCoursParSemaine());
        model.addAttribute("nbInstrumentsDisponibles",
                instrumentService.filtrer(null, true).size());
        model.addAttribute("nbInstrumentsIndisponibles",
                instrumentService.filtrer(null, false).size());

        return "stats/dashboard";
    }
}
