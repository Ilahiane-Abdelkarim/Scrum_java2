package com.scrum.service;

import com.scrum.bean.*;
import com.scrum.dao.TacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TacheService {
    public Tache findByCode(String code) {
        return tacheDao.findByCode(code);
    }

    public List<Tache> findByProjetCode(String code) {
        return tacheDao.findByProjetCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return tacheDao.deleteByCode(code);
    }

    public List<Tache> findAll() {
        return tacheDao.findAll();
    }

    public int save(Tache tache){
        EtatTache etatTache = etatTacheService.findByCode(tache.getEtat().getCode());
        Projet projet = projetService.findByCode(tache.getProjet().getCode());
        if(etatTache == null){
            return -1;
        }else if(projet == null){
            return -2;
        }else {
            tache.setEtat(etatTache);
            tache.setProjet(projet);
            tacheDao.save(tache);
            return 1;
        }
    }
    public int update(String code,String newCode,String projetCode, String libelle, String etatCode){
        Tache tache = findByCode(code);
        Projet projet = projetService.findByCode(projetCode);
        EtatTache etatTache = etatTacheService.findByCode(etatCode);
        if(tache==null){
            return -1;
        }else {
            if(newCode !=null ){
                if(findByCode(newCode)!=null){
                    return  -2;
                }else{
                        tache.setCode(newCode);
                }
            }
            if(libelle != null){
                tache.setLibelle(libelle);
            }
            if(projet != null){
                tache.setProjet(projet);
            }
            if(etatTache != null){
                tache.setEtat(etatTache);
            }
            tacheDao.save(tache);
            return 1;
        }
    }

    @Autowired
    private EtatTacheService etatTacheService;
    @Autowired
    private ProjetService projetService;



    @Autowired
    private TacheDao tacheDao;
}
