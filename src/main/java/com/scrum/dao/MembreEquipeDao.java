package com.scrum.dao;

import com.scrum.bean.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreEquipeDao extends JpaRepository<MembreEquipe, Long> {
    List<MembreEquipe> findByEquipeCode(String code);
    int deleteByEquipeCode(String code);
}
