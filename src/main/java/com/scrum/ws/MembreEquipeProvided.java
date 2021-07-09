package com.scrum.ws;


import com.scrum.bean.MembreEquipe;
import com.scrum.service.EquipeService;
import com.scrum.service.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/membreEquipe")
public class MembreEquipeProvided {

    @GetMapping("/equipe/code/{code}")
    public List<MembreEquipe> findByEquipeCode(@PathVariable String code) {
        return membreEquipeService.findByEquipeCode(code);
    }


    @DeleteMapping("equipe/code/{code}")
    public int deleteByEquipeCode(@PathVariable String code) {
        return membreEquipeService.deleteByEquipeCode(code);
    }

    @GetMapping("/")
    public List<MembreEquipe> findAll() {
        return membreEquipeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody MembreEquipe membreEquipe) {
        return membreEquipeService.save(membreEquipe);
    }

    @Autowired
    private MembreEquipeService membreEquipeService;
}
