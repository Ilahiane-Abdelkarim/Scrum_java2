package com.scrum.service;


import com.scrum.bean.Client;
import com.scrum.bean.Collaborateur;
import com.scrum.dao.CollaborateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollaborateurService {

    public Collaborateur findByEmail(String email) {
        return collaborateurDao.findByEmail(email);
    }

    public List<Collaborateur> findByNom(String nom) {
        return collaborateurDao.findByNom(nom);
    }

    public List<Collaborateur> findByPrenom(String prenom) {
        return collaborateurDao.findByPrenom(prenom);
    }

    public List<Collaborateur> findByNomAndPrenom(String nom, String prenom) {
        return collaborateurDao.findByNomAndPrenom(nom, prenom);
    }

    @Transactional
    public int deleteByEmail(String email) {
        return collaborateurDao.deleteByEmail(email);
    }
    public List<Collaborateur> findAll() {
        return collaborateurDao.findAll();
    }

    public int save(Collaborateur collaborateur){
        if(findByEmail(collaborateur.getEmail())!=null){
            return -1;
        }else {
            collaborateurDao.save(collaborateur);
            return 1;
        }
    }
    public int updateByEmail(String email, String newEmail, String nom, String prenom){
        Collaborateur collaborateur = findByEmail(email);
        if(collaborateur==null){
            return -1;
        }else {
            if(newEmail !=null){
                if(findByEmail(newEmail)!=null){
                    return  -2;
                }else{
                    collaborateur.setEmail(newEmail);
                }
            }
            if(nom != null){
                collaborateur.setNom(nom);
            }
            if(prenom != null){
                collaborateur.setPrenom(prenom);
            }
            collaborateurDao.save(collaborateur);
            return 1;
        }
    }

    @Autowired
    private CollaborateurDao collaborateurDao;
}
