package com.scrum.ws;

import com.scrum.bean.Collaborateur;
import com.scrum.service.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/collaborateur")
public class CollaborateurProvided {
    @GetMapping("/email/{email}")
    public Collaborateur findByEmail(@PathVariable String email) {
        return collaborateurService.findByEmail(email);
    }

    @GetMapping("/nom/{nom}")
    public List<Collaborateur> findByNom(@PathVariable String nom) {
        return collaborateurService.findByNom(nom);
    }

    @GetMapping("/prenom/{prenom}")
    public List<Collaborateur> findByPrenom(@PathVariable String prenom) {
        return collaborateurService.findByPrenom(prenom);
    }

    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public List<Collaborateur> findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return collaborateurService.findByNomAndPrenom(nom,prenom);
    }

    @DeleteMapping("/email/{email}")
    public int deleteByEmail(@PathVariable String email) {
        return collaborateurService.deleteByEmail(email);
    }

    @GetMapping("/")
    public List<Collaborateur> findAll() {
        return collaborateurService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Collaborateur collaborateur) {
        return collaborateurService.save(collaborateur);
    }

    @PutMapping("/email/{email}/nom/{nom}/prenom/{prenom}")
    public int updateByEmail(@PathVariable String email, String newEmail, String nom, String prenom) {
        return collaborateurService.updateByEmail(email, newEmail, nom, prenom);
    }

    @Autowired
    private CollaborateurService collaborateurService;
}
