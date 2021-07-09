package com.scrum.dao;

import com.scrum.bean.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotDao extends JpaRepository<Lot, Long> {

    Lot findByCode(String code);
    List<Lot> findByLibelle(String libelle);
    List<Lot> findByProjetCode(String code);
    List<Lot> findByCategorieCode(String code);
    int deleteByCode(String code);
}
