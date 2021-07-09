package com.scrum.dao;


import com.scrum.bean.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaborateurDao extends JpaRepository<Collaborateur, Long> {

    Collaborateur findByEmail(String email);
    List<Collaborateur> findByNom(String nom);
    List<Collaborateur> findByPrenom(String prenom);
    List<Collaborateur> findByNomAndPrenom(String nom,String prenom);
    int deleteByEmail(String email);

}
