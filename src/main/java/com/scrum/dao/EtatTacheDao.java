package com.scrum.dao;

import com.scrum.bean.EtatTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtatTacheDao extends JpaRepository<EtatTache, Long> {
    EtatTache findByCode(String code);
    List<EtatTache> findByLibelle(String libelle);
    int deleteByCode(String code);
}
