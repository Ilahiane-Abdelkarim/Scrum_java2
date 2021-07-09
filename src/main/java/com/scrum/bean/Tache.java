package com.scrum.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id ;
    private String libelle ;
    private String code ;
    private Date datedebut;
    private Date datefin ;
    @ManyToOne
    private EtatTache etat;
    @ManyToOne
    private Projet projet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public EtatTache getEtat() {
        return etat;
    }

    public void setEtat(EtatTache etat) {
        this.etat = etat;
    }


    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
