package com.scrum.service;

import com.scrum.bean.Categorie;
import com.scrum.dao.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategorieService {


    public Categorie findByCode(String code) {
        return categorieDao.findByCode(code);
    }

    public List<Categorie> findByLibelle(String libelle) {
        return categorieDao.findByLibelle(libelle);
    }

    @Transactional
    public int deleteByCode(String code) {
        return categorieDao.deleteByCode(code);
    }

    public List<Categorie> findAll() {
        return categorieDao.findAll();
    }

    public int save(Categorie categorie){
        if(findByCode(categorie.getCode())!=null){
            return -1;
        }else {
            categorieDao.save(categorie);
            return 1;
        }
    }
    public int updateByCode(String code, String newCode, String libelle){
        Categorie categorie = findByCode(code);
        if(categorie==null){
            return -1;
        }else {
            if(newCode !=null){
                if(findByCode(newCode)!=null){
                    return  -2;
                }else{
                    categorie.setCode(newCode);
                }
            }else if(newCode != null){
                categorie.setCode(newCode);
            }
            if(libelle != null){
                categorie.setLibelle(libelle);
            }
            categorieDao.save(categorie);
            return 1;
        }
    }

    @Autowired
    private CategorieDao categorieDao;
}
