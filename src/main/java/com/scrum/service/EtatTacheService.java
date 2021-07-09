package com.scrum.service;


import com.scrum.bean.EtatTache;
import com.scrum.dao.EtatTacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EtatTacheService {
    public EtatTache findByCode(String code) {
        return etatTacheDao.findByCode(code);
    }

    public List<EtatTache> findByLibelle(String libelle) {
        return etatTacheDao.findByLibelle(libelle);
    }

    @Transactional
    public int deleteByCode(String code) {
        return etatTacheDao.deleteByCode(code);
    }

    public List<EtatTache> findAll() {
        return etatTacheDao.findAll();
    }
    public int save(EtatTache etatTache){
        if(findByCode(etatTache.getCode())!=null){
            return -1;
        }else {
            etatTacheDao.save(etatTache);
            return 1;
        }
    }
    public int update(String code, String newCode, String libelle){
        EtatTache etatTache = findByCode(code);
        if(etatTache==null){
            return -1;
        }else {
            if(newCode !=null){
                if(findByCode(newCode)!=null){
                    return  -2;
                }else{
                    etatTache.setCode(newCode);
                }
            }
            if(libelle != null){
                etatTache.setLibelle(libelle);
            }
            etatTacheDao.save(etatTache);
            return 1;
        }
    }

    @Autowired
    private EtatTacheDao etatTacheDao;
}
