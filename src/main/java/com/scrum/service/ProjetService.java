package com.scrum.service;


import com.scrum.bean.Client;
import com.scrum.bean.Projet;
import com.scrum.dao.ProjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjetService {

    public Projet findByCode(String code) {
        return projetDao.findByCode(code);
    }

    public List<Projet> findByRef(String ref) {
        return projetDao.findByRef(ref);
    }

    public List<Projet> findByLibelle(String libelle) {
        return projetDao.findByLibelle(libelle);
    }

    public List<Projet> findByAvancement(String avancement) {
        return projetDao.findByAvancement(avancement);
    }

    public List<Projet> findByClientEmail(String email) {
        return projetDao.findByClientEmail(email);
    }

    @Transactional
    public int deleteByCode(String code) {
        return projetDao.deleteByCode(code);
    }

    public List<Projet> findAll() {
        return projetDao.findAll();
    }

    public int save(Projet projet){
        Client client = clientService.findByEmail(projet.getClient().getEmail());
        if(findByCode(projet.getCode())!=null){
            return -1;
        }else if(client ==null){
            return -2;
        }
        else {
            projet.setClient(client);
            projetDao.save(projet);
            return 1;
        }
    }
    public int updateByCode(String code, String newCode,String ref,String libelle,String avancement, String color, String emailClient) {
        Projet foundedProjet = findByCode(code);
        Client client = clientService.findByEmail(emailClient);
        if(foundedProjet==null){
            return -1;
        }else{
            if(newCode !=null){
                if(findByCode(newCode)!=null){
                    return  -2;
                }else{
                    foundedProjet.setCode(newCode);
                }
            }
            if(ref !=null){
                foundedProjet.setRef(ref);
            }
            if(libelle !=null){
                foundedProjet.setLibelle(libelle);
            }
            if(avancement !=null){
                foundedProjet.setAvancement(avancement);
            }
            if(color !=null){
                foundedProjet.setColor(color);
            }
            if(client !=null){
                foundedProjet.setClient(client);
            }
            projetDao.save(foundedProjet);
            return 1;
        }
    }

    @Autowired
    private ProjetDao projetDao;

    @Autowired
    private ClientService clientService;
}
