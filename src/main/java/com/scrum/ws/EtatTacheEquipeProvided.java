package com.scrum.ws;

import com.scrum.bean.EtatTache;
import com.scrum.service.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/equipetache")
public class EtatTacheEquipeProvided {
    @GetMapping("/code/{code}")
    public EtatTache findByCode(@PathVariable String code) {
        return etatTacheService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public List<EtatTache> findByLibelle(@PathVariable String libelle) {
        return etatTacheService.findByLibelle(libelle);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return etatTacheService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<EtatTache> findAll() {
        return etatTacheService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody EtatTache etatTache) {
        return etatTacheService.save(etatTache);
    }

    @PutMapping("/code/{code}/newCode/{newCode}/libelle/{libelle}")
    public int update(@PathVariable String code, @PathVariable String newCode, @PathVariable String libelle) {
        return etatTacheService.update(code, newCode, libelle);
    }

    @Autowired
    private EtatTacheService etatTacheService;
}
