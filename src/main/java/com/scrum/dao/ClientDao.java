package com.scrum.dao;


import com.scrum.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
    Client findByEmailAndPsw(String email, String psw);
    List<Client> findByNom(String nom);
    List<Client> findByPrenom(String prenom);
    List<Client> findByNomAndPrenom(String nom,String prenom);
    int deleteByEmail(String email);
}
