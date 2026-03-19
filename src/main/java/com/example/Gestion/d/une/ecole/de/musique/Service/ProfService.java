package com.example.Gestion.d.une.ecole.de.musique.Service;

import com.example.Gestion.d.une.ecole.de.musique.Repository.ProfRepository;
import com.example.Gestion.d.une.ecole.de.musique.entity.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfService {

    @Autowired
    private ProfRepository profRepository;

    public List<Prof> getAll() {
        return profRepository.findAll();
    }

    public Prof getById(Long id) {
        return profRepository.findById(id).orElse(null);
    }

    public Prof save(Prof prof) {
        return profRepository.save(prof);
    }

    public void delete(Long id) {
        profRepository.deleteById(id);
    }
}