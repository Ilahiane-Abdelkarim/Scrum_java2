package com.scrum.dao;

import com.scrum.bean.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheDao extends JpaRepository<Tache, Long> {

    Tache findByCode(String code);
    List<Tache> findByProjetCode(String code);
    int deleteByCode(String code);
}
