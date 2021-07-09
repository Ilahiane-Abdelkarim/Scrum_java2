package com.scrum.ws;


import com.scrum.bean.Equipe;
import com.scrum.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/equipe")
public class EquipeProvided {
    @GetMapping("/code/{code}")
    public Equipe findByCode(@PathVariable String code) {
        return equipeService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public List<Equipe> findByLibelle(@PathVariable String libelle) {
        return equipeService.findByLibelle(libelle);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return equipeService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Equipe equipe) {
        return equipeService.save(equipe);
    }

    @PutMapping("/code/{code}/newCode/{newCode}/libelle/{libelle}")
    public int updateByCode(@PathVariable String code, String newCode, String libelle) {
        return equipeService.updateByCode(code, newCode, libelle);
    }



    @Autowired
    private EquipeService equipeService;
}
