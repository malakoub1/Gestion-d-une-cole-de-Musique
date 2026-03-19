package com.example.Gestion.d.une.ecole.de.musique.Service;

import com.example.Gestion.d.une.ecole.de.musique.Repository.InstrumentRepository;
import com.example.Gestion.d.une.ecole.de.musique.entity.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    public List<Instrument> getAll() {
        return instrumentRepository.findAll();
    }

    public Instrument getById(Long id) {
        return instrumentRepository.findById(id).orElse(null);
    }

    public Instrument save(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    public void delete(Long id) {
        instrumentRepository.deleteById(id);
    }

    public List<Instrument> filtrer(String famille, Boolean disponibilite) {
        if (famille != null && !famille.isEmpty() && disponibilite != null) {
            return instrumentRepository.findByFamilleAndDisponibilite(famille, disponibilite);
        }
        if (famille != null && !famille.isEmpty()) {
            return instrumentRepository.findByFamille(famille);
        }
        if (disponibilite != null) {
            return instrumentRepository.findByDisponibilite(disponibilite);
        }
        return instrumentRepository.findAll();
    }
}