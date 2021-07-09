package com.scrum.service;


import com.scrum.bean.Client;
import com.scrum.bean.Collaborateur;
import com.scrum.bean.Equipe;
import com.scrum.bean.MembreEquipe;
import com.scrum.dao.EquipeDao;
import com.scrum.dao.MembreEquipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MembreEquipeService {

    public List<MembreEquipe> findByEquipeCode(String code) {
        return membreEquipeDao.findByEquipeCode(code);
    }


    @Transactional
    public int deleteByEquipeCode(String code) {
        return membreEquipeDao.deleteByEquipeCode(code);
    }

    public List<MembreEquipe> findAll() {
        return membreEquipeDao.findAll();
    }

    public int save(MembreEquipe membreEquipe){
        Equipe equipe = equipeService.findByCode(membreEquipe.getEquipe().getCode());
        Client client = clientService.findByEmail(membreEquipe.getClient().getEmail());
        Collaborateur admin = collaborateurService.findByEmail(membreEquipe.getAdmin().getEmail());
        Collaborateur collaborateur = collaborateurService.findByEmail(membreEquipe.getCollaborateur().getEmail());
        if(equipe==null){
            return -1;
        }else if(client==null){
            return -2;
        }else if(admin==null){
            return -3;
        }else if(collaborateur==null){
            return -4;
        }else {
            membreEquipe.setEquipe(equipe);
            membreEquipe.setClient(client);
            membreEquipe.setAdmin(admin);
            membreEquipe.setCollaborateur(collaborateur);
            membreEquipeDao.save(membreEquipe);
            return 1;
        }
    }

    @Autowired
    private ClientService clientService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private MembreEquipeDao membreEquipeDao;
}
