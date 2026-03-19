package com.example.Gestion.d.une.ecole.de.musique.Repository;

import com.example.Gestion.d.une.ecole.de.musique.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    List<Instrument> findByFamille(String famille);
    List<Instrument> findByDisponibilite(boolean disponibilite);
    List<Instrument> findByFamilleAndDisponibilite(String famille, boolean disponibilite);
}