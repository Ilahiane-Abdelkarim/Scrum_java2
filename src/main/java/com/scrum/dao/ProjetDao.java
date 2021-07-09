package com.scrum.dao;

import com.scrum.bean.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetDao extends JpaRepository<Projet, Long> {

    Projet findByCode(String code);
    List<Projet> findByRef(String ref);
    List<Projet> findByLibelle(String libelle);
    List<Projet> findByAvancement(String avancement);
    List<Projet> findByClientEmail(String email);
    int deleteByCode(String code);
}
