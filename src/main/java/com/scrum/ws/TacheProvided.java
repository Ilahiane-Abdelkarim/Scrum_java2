package com.scrum.ws;


import com.scrum.bean.Tache;
import com.scrum.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/tache")
public class TacheProvided {
    @GetMapping("/code/{code}")
    public Tache findByCode(@PathVariable String code) {
        return tacheService.findByCode(code);
    }

    @GetMapping("/projet/code/{code}")
    public List<Tache> findByProjetCode(@PathVariable String code) {
        return tacheService.findByProjetCode(code);
    }



    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return tacheService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Tache> findAll() {
        return tacheService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Tache tache) {
        return tacheService.save(tache);
    }

    @PutMapping("/code/{code}/newCode/{newCode}/projetCode/{projetCode}/libelle/{libelle}/etatCode/{etatCode}")
    public int update(@PathVariable String code,String newCode, String projetCode, String libelle, String etatCode) {
        return tacheService.update(code, newCode, projetCode, libelle, etatCode);
    }

    @Autowired
    private TacheService tacheService;
}
