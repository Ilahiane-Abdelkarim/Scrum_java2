package com.scrum.dao;

import com.scrum.bean.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
    Equipe findByCode(String code);
    List<Equipe> findByLibelle(String libelle);
    int deleteByCode(String code);
}
