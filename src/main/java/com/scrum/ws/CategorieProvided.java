package com.scrum.ws;

import com.scrum.bean.Categorie;
import com.scrum.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/categorie")
public class CategorieProvided {

    @GetMapping("/code/{code}")
    public Categorie findByCode(@PathVariable String code) {
        return categorieService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public List<Categorie> findByLibelle(@PathVariable String libelle) {
        return categorieService.findByLibelle(libelle);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }

    @PutMapping("/code/{code}/newCode/{newCode}/libelle/{libelle}")
    public int updateByCode(@PathVariable String code, String newCode, String libelle) {
        return categorieService.updateByCode(code, newCode, libelle);
    }

    @Autowired
    private CategorieService categorieService;

}
