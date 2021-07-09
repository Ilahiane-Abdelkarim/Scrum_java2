package com.scrum.bean;

import javax.persistence.*;

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String ref;
    private String libelle;
    private String code;
    @ManyToOne
    private Client client;
    private String avancement;
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAvancement() {
        return avancement;
    }

    public void setAvancement(String avancement) {
        this.avancement = avancement;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
