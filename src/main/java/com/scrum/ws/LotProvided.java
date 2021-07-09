package com.scrum.ws;

import com.scrum.bean.Lot;
import com.scrum.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/lot")
public class LotProvided {

    @GetMapping("/code/{code}")
    public Lot findByCode(@PathVariable String code) {
        return lotService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public List<Lot> findByLibelle(@PathVariable String libelle) {
        return lotService.findByLibelle(libelle);
    }

    @GetMapping("/projet/code/{code}")
    public List<Lot> findByProjetCode(@PathVariable String code) {
        return lotService.findByProjetCode(code);
    }

    @GetMapping("/categorie/code/{code}")
    public List<Lot> findByCategorieCode(@PathVariable String code) {
        return lotService.findByCategorieCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return lotService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Lot> findAll() {
        return lotService.findAll();
    }

    @PostMapping("/")
    public int save(Lot lot) {
        return lotService.save(lot);
    }

    @PutMapping("/code/{code}/newCode/{newCode}/libelle/{libelle}/codeProject/{codeProject}/codeCategorie/{codeCategorie}")
    public int updateByCode(@PathVariable String code, String newCode, String libelle, String codeProject, String codeCategorie) {
        return lotService.updateByCode(code, newCode, libelle, codeProject, codeCategorie);
    }

    @Autowired
    private LotService lotService;
}
