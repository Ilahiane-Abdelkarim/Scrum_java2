package com.scrum.ws;

import com.scrum.bean.Projet;
import com.scrum.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/projet")
public class ProjetProvided {

    @GetMapping("/code/{code}")
    public Projet findByCode(@PathVariable String code) {
        return projetService.findByCode(code);
    }

    @GetMapping("/ref/{ref}")
    public List<Projet> findByRef(@PathVariable String ref) {
        return projetService.findByRef(ref);
    }

    @GetMapping("/libelle/{libelle}")
    public List<Projet> findByLibelle(@PathVariable String libelle) {
        return projetService.findByLibelle(libelle);
    }

    @GetMapping("/avancement/{avancement}")
    public List<Projet> findByAvancement(@PathVariable String avancement) {
        return projetService.findByAvancement(avancement);
    }

    @GetMapping("/client/email/{email}")
    public List<Projet> findByClientEmail(@PathVariable String email) {
        return projetService.findByClientEmail(email);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return projetService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Projet> findAll() {
        return projetService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Projet projet) {
        return projetService.save(projet);
    }

    @PutMapping("/code/{code}/newCode/{newCode}/ref/{ref}/libelle/{libelle}/avancement/{avancement}/color/{color}/emailClient/{emailClient}")
    public int updateByCode(@PathVariable String code, String newCode,  String ref, String libelle, String avancement, String color, String emailClient) {
        return projetService.updateByCode(code, newCode, ref, libelle, avancement, color, emailClient);
    }

    @Autowired
    private ProjetService projetService;
}
