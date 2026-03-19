package com.example.Gestion.d.une.ecole.de.musique.Service;

import com.example.Gestion.d.une.ecole.de.musique.Repository.CoursRepository;
import com.example.Gestion.d.une.ecole.de.musique.Repository.ProfRepository;
import com.example.Gestion.d.une.ecole.de.musique.entity.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private ProfRepository profRepository;

    public List<Cours> getAll() {
        return coursRepository.findAll();
    }

    public Cours getById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    public Cours save(Cours cours) {
        return coursRepository.save(cours);
    }

    public void delete(Long id) {
        coursRepository.deleteById(id);
    }

    public List<Cours> filtrer(String niveau, String jour) {
        if (niveau != null && !niveau.isEmpty() && jour != null && !jour.isEmpty()) {
            return coursRepository.findByNiveauAndJour(niveau, jour);
        }
        if (niveau != null && !niveau.isEmpty()) {
            return coursRepository.findByNiveau(niveau);
        }
        if (jour != null && !jour.isEmpty()) {
            return coursRepository.findByJour(jour);
        }
        return coursRepository.findAll();
    }

    public long nombreCoursParSemaine() {
        return coursRepository.count();
    }
}
