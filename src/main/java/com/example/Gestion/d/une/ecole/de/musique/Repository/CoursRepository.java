package com.example.Gestion.d.une.ecole.de.musique.Repository;

import com.example.Gestion.d.une.ecole.de.musique.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findByNiveau(String niveau);
    List<Cours> findByJour(String jour);
    List<Cours> findByNiveauAndJour(String niveau, String jour);

    long countByJourIn(List<String> jours);
}