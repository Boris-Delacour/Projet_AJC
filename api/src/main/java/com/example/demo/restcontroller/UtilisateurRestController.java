package com.example.demo.restcontroller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.dto.request.UtilisateurRequest;
import com.example.demo.dto.response.FormateurResponse;
import com.example.demo.dto.response.GestionnaireResponse;
import com.example.demo.dto.response.StagiaireResponse;
import com.example.demo.dto.response.TechnicienResponse;
import com.example.demo.dto.response.UtilisateurResponse;
import com.example.demo.model.Role;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.FormateurService;
import com.example.demo.service.GestionnaireService;
import com.example.demo.service.StagiaireService;
import com.example.demo.service.TechnicienService;
import com.example.demo.service.UtilisateurService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/utilisateur")
@SecurityRequirement(name = "basicAuth")
@CrossOrigin(origins = "*")
public class UtilisateurRestController {

    @Autowired
    private UtilisateurService uSrv;

    @Autowired
    private GestionnaireService gSrv;

    @Autowired
    private TechnicienService tSrv;

    @Autowired
    private FormateurService fSrv;

    @Autowired
    private StagiaireService sSrv;

    @GetMapping("/{id}/gestionnaire")
    @JsonView(CustomJsonViews.GestionnaireWithFormations.class)
    public GestionnaireResponse getGestionnaire(@PathVariable Integer id) {
        Utilisateur utilisateur = this.uSrv.getById(id);

        return new GestionnaireResponse(this.gSrv.getWithFormations(utilisateur.getIdRole()));
    }

    @GetMapping("/{id}/technicien")
    @JsonView(CustomJsonViews.Common.class)
    public TechnicienResponse getTechnicien(@PathVariable Integer id) {
        Utilisateur utilisateur = this.uSrv.getById(id);

        return new TechnicienResponse(this.tSrv.getById(utilisateur.getIdRole()));
    }

    @GetMapping("/{id}/formateur")
    @JsonView(CustomJsonViews.FormateurWithAll.class)
    public FormateurResponse getFormateur(@PathVariable Integer id) {
        Utilisateur utilisateur = this.uSrv.getById(id);

        return new FormateurResponse(this.fSrv.getWithAll(utilisateur.getIdRole()));
    }

    @GetMapping("/{id}/stagiaire")
    @JsonView(CustomJsonViews.StagiaireWithAll.class)
    public StagiaireResponse getStagiaire(@PathVariable Integer id) {
        Utilisateur utilisateur = this.uSrv.getById(id);

        return new StagiaireResponse(this.sSrv.getWithAll(utilisateur.getIdRole()));
    }

    @GetMapping("/{username}")
    @JsonView(CustomJsonViews.StagiaireWithAll.class)
    public UtilisateurResponse getByUsername(@PathVariable String username) {
        return new UtilisateurResponse(this.uSrv.getByUsername(username));
    }

    @PostMapping("/create")
    public UtilisateurResponse create(@Valid @RequestBody UtilisateurRequest ur) {
        Utilisateur utilisateur = new Utilisateur();
        BeanUtils.copyProperties(ur, utilisateur, "role");
        return new UtilisateurResponse(this.uSrv.create(utilisateur, Role.valueOf(ur.getRole())));
    }

    @PostMapping("/inscription")
    public UtilisateurResponse inscription(@Valid @RequestBody UtilisateurRequest ur) {
        Utilisateur utilisateur = new Utilisateur();
        BeanUtils.copyProperties(ur, utilisateur, "role");
        return new UtilisateurResponse(this.uSrv.create(utilisateur, Role.valueOf(ur.getRole())));
    }

}
