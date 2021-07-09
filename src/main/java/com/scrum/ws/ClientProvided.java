package com.scrum.ws;

import com.scrum.bean.Client;
import com.scrum.service.CategorieService;
import com.scrum.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("scrum-gestion/client")
public class ClientProvided {
    @GetMapping("/email/{email}")
    public Client findByEmail(@PathVariable String email) {
        return clientService.findByEmail(email);
    }

    @GetMapping("/email/{email}/psw/{psw}")
    public Client findByEmailAndPsw(@PathVariable String email, @PathVariable String psw) {
        return clientService.findByEmailAndPsw(email,psw);
    }

    @GetMapping("/nom/{nom}")
    public List<Client> findByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @GetMapping("/prenom/{prenom}")
    public List<Client> findByPrenom(@PathVariable String prenom) {
        return clientService.findByPrenom(prenom);
    }

    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public List<Client> findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return clientService.findByNomAndPrenom(nom,prenom);
    }

    @DeleteMapping("/email/{email}")
    public int deleteByEmail(@PathVariable String email) {
        return clientService.deleteByEmail(email);
    }

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/email/{email}/nom/{nom}/prenom/{prenom}/psw/{psw}")
    public int updateByEmail(@PathVariable String email, String nom, String prenom, String psw) {
        return clientService.updateByEmail(email, nom, prenom,psw);
    }

    @Autowired
    private ClientService clientService;
}
