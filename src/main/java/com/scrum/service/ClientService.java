package com.scrum.service;


import com.scrum.bean.Categorie;
import com.scrum.bean.Client;
import com.scrum.dao.CategorieDao;
import com.scrum.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    public Client findByEmail(String email) {
        return clientDao.findByEmail(email);
    }
    public Client findByEmailAndPsw(String email, String psw) {
        return clientDao.findByEmailAndPsw(email,psw);
    }
    public List<Client> findByNom(String nom) {
        return clientDao.findByNom(nom);
    }
    public List<Client> findByPrenom(String prenom) {
        return clientDao.findByPrenom(prenom);
    }
    public List<Client> findByNomAndPrenom(String nom, String prenom) {
        return clientDao.findByNomAndPrenom(nom,prenom);
    }

    @Transactional
    public int deleteByEmail(String email) {
        return clientDao.deleteByEmail(email);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public int save(Client client){
        if(findByEmail(client.getEmail())!=null){
            return -1;
        }else {
            clientDao.save(client);
            return 1;
        }
    }
    public int updateByEmail(String email, String nom, String prenom, String psw){
        Client client = findByEmail(email);
        if(client==null){
            return -1;
        }else {
            if(nom != null){
                client.setNom(nom);
            }
            if(prenom != null){
                client.setPrenom(prenom);
            }if(psw != null){
                client.setPsw(psw);
            }
            clientDao.save(client);
            return 1;
        }
    }

    @Autowired
    private ClientDao clientDao;
}
