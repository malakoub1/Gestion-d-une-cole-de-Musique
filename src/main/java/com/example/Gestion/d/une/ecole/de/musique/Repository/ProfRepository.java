package com.example.Gestion.d.une.ecole.de.musique.Repository;

import com.example.Gestion.d.une.ecole.de.musique.entity.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfRepository extends JpaRepository<Prof, Long> {
    List<Prof> findBySpecialite(String specialite);
}