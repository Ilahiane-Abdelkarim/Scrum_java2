package com.scrum.bean;

import javax.persistence.*;

@Entity
public class MembreEquipe {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id ;
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Collaborateur collaborateur;
    @ManyToOne
    private Collaborateur admin;
    @ManyToOne
    private Client client;
    private int active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Collaborateur getAdmin() {
        return admin;
    }

    public void setAdmin(Collaborateur admin) {
        this.admin = admin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
