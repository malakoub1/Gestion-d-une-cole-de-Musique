package com.example.Gestion.d.une.ecole.de.musique.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jour;
    private LocalTime heureDebut;
    private Integer dureeMin;
    private String niveau;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private Prof prof;

    public Cours() {
    }

    public Cours(Long id, String jour, LocalTime heureDebut, Integer dureeMin, String niveau, Prof prof) {
        this.id = id;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.dureeMin = dureeMin;
        this.niveau = niveau;
        this.prof = prof;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Integer getDureeMin() {
        return dureeMin;
    }

    public void setDureeMin(Integer dureeMin) {
        this.dureeMin = dureeMin;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }
}