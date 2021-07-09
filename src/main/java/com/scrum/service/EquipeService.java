package com.scrum.service;

import com.scrum.bean.Categorie;
import com.scrum.bean.Equipe;
import com.scrum.dao.EquipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EquipeService {
    public Equipe findByCode(String code) {
        return equipeDao.findByCode(code);
    }

    public List<Equipe> findByLibelle(String libelle) {
        return equipeDao.findByLibelle(libelle);
    }

    @Transactional
    public int deleteByCode(String code) {
        return equipeDao.deleteByCode(code);
    }

    public List<Equipe> findAll() {
        return equipeDao.findAll();
    }
    public int save(Equipe equipe){
        if(findByCode(equipe.getCode())!=null){
            return -1;
        }else {
            equipeDao.save(equipe);
            return 1;
        }
    }
    public int updateByCode(String code, String newCode, String libelle){
        Equipe equipe = findByCode(code);
        if(equipe==null){
            return -1;
        }else {
            if(newCode !=null){
                if(findByCode(newCode)!=null){
                    return  -2;
                }else{
                    equipe.setCode(newCode);
                }
            }
            if(libelle != null){
                equipe.setLibelle(libelle);
            }
            equipeDao.save(equipe);
            return 1;
        }
    }



    @Autowired
    private EquipeDao equipeDao;
}
