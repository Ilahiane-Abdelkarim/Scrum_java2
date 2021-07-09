package com.scrum.dao;

import com.scrum.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Long> {

    Categorie findByCode(String code);
    List<Categorie> findByLibelle(String libelle);
    int deleteByCode(String code);
}
