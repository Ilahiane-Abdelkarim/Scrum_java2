package com.scrum.service;

import com.scrum.bean.Categorie;
import com.scrum.bean.Client;
import com.scrum.bean.Lot;
import com.scrum.bean.Projet;
import com.scrum.dao.LotDao;
import com.scrum.dao.ProjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LotService {

    public Lot findByCode(String code) {
        return lotDao.findByCode(code);
    }

    public List<Lot> findByLibelle(String libelle) {
        return lotDao.findByLibelle(libelle);
    }

    public List<Lot> findByProjetCode(String code) {
        return lotDao.findByProjetCode(code);
    }

    public List<Lot> findByCategorieCode(String code) {
        return lotDao.findByCategorieCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return lotDao.deleteByCode(code);
    }

    public List<Lot> findAll() {
        return lotDao.findAll();
    }

    public int save(Lot lot){
        Projet projet = projetService.findByCode(lot.getProjet().getCode());
        Categorie categorie = categorieService.findByCode(lot.getCategorie().getCode());
        if(findByCode(lot.getCode())!=null){
            return -1;
        }else if(projet ==null){
            return -2;
        }else if(categorie ==null){
            return -3;
        }
        else {
            lot.setProjet(projet);
            lot.setCategorie(categorie);
            lotDao.save(lot);
            return 1;
        }
    }

    public int updateByCode(String code,String newCode,String libelle,String codeProject, String codeCategorie) {
        Lot foundedLot = findByCode(code);
        Projet projet = projetService.findByCode(codeProject);
        Categorie categorie = categorieService.findByCode(codeCategorie);
        if(foundedLot==null){
            return -1;
        }else{
            if(newCode !=null) {
                if(findByCode(newCode)!=null){
                    return  -2;
                }else{
                    foundedLot.setCode(newCode);
                }
            }
            if(libelle !=null) {
                foundedLot.setLibelle(libelle);
            }
            if(projet !=null){
                foundedLot.setProjet(projet);
            }
            if(categorie !=null){
                foundedLot.setCategorie(categorie);
            }
            lotDao.save(foundedLot);
            return 1;
        }
    }

    @Autowired
    private LotDao lotDao;

    @Autowired
    private ProjetService projetService;
    @Autowired
    private CategorieService categorieService;
}
