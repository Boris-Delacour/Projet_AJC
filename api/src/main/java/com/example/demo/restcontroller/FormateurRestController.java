package com.example.demo.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.dto.request.FormateurRequest;
import com.example.demo.dto.request.MatiereRequest;
import com.example.demo.dto.response.FormateurResponse;
import com.example.demo.model.Formateur;
import com.example.demo.model.FormateurMatiere;
import com.example.demo.model.FormateurMatiereKey;
import com.example.demo.model.Matiere;
import com.example.demo.model.Role;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.FormateurMatiereService;
import com.example.demo.service.FormateurService;
import com.example.demo.service.MatiereService;
import com.example.demo.service.UtilisateurService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/formateur")
@SecurityRequirement(name = "basicAuth")
@CrossOrigin(origins = "*")
public class FormateurRestController {

    @Autowired
    private FormateurService fSrv;

    @Autowired
    private UtilisateurService uSrv;

    @Autowired
    private MatiereService mSrv;

    @Autowired
    private FormateurMatiereService fmSrv;

    @GetMapping("")
    @JsonView(CustomJsonViews.Common.class)
    public List<FormateurResponse> getAll() {
        return fSrv.getAll().stream().map(formateur -> new FormateurResponse(formateur))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public FormateurResponse getById(@PathVariable Integer id) {
        return new FormateurResponse(fSrv.getById(id));
    }

    @GetMapping("/{id}/infos")
    @JsonView(CustomJsonViews.FormateurWithAll.class)
    public FormateurResponse getWithAll(@PathVariable Integer id) {
        return new FormateurResponse(fSrv.getWithAll(id), true);
    }

    @GetMapping("/{id}/formations")
    @JsonView(CustomJsonViews.FormateurWithFormations.class)
    public FormateurResponse getWithFormations(@PathVariable Integer id) {
        return new FormateurResponse(fSrv.getWithFormations(id), true);
    }

    @GetMapping("/{id}/matieres")
    @JsonView(CustomJsonViews.FormateurWithMatiere.class)
    public FormateurResponse getWithMatieres(@PathVariable Integer id) {
        return new FormateurResponse(fSrv.getWithMatieres(id), true);
    }

    @GetMapping("/{id}/indisponibilites")
    @JsonView(CustomJsonViews.FormateurWithIndisponibilites.class)
    public FormateurResponse getWithIndisponibilites(@PathVariable Integer id) {
        return new FormateurResponse(fSrv.getWithMatieres(id), true);
    }

    @GetMapping("/{id}/matiereparformations")
    @JsonView(CustomJsonViews.FormateurWithFormations.class)
    public FormateurResponse getWithMatiereParFormations(@PathVariable("id") Integer id) {
        return new FormateurResponse(fSrv.getWithMatiereParFormations(id), true);
    }

    @GetMapping("/withoutmatiere/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public List<FormateurResponse> getWithoutMatiere(@PathVariable("id") Integer id) {
        Matiere matiere = mSrv.getById(id);
        return fSrv.getWithoutMatiere(matiere).stream().map(formateur -> new FormateurResponse(formateur))
                .collect(Collectors.toList());
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(CustomJsonViews.Common.class)
    public FormateurResponse create(@Valid @RequestBody FormateurRequest fr, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Formateur formateur = new Formateur();
        BeanUtils.copyProperties(fr, formateur, "id");
        FormateurResponse res = new FormateurResponse(fSrv.insert(formateur));
        return res;
    }

    @PutMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public FormateurResponse update(@Valid @RequestBody FormateurRequest fr, BindingResult br,
            @PathVariable Integer id) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Formateur formateur = fSrv.getById(id);
        BeanUtils.copyProperties(fr, formateur);
        return new FormateurResponse(fSrv.update(formateur));
    }

    @PutMapping("/{id}/matiere")
    @JsonView(CustomJsonViews.Common.class)
    public void addMatiere(@Valid @RequestBody MatiereRequest mr, BindingResult br,
            @PathVariable Integer id) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Formateur formateur = fSrv.getWithAll(id);
        Matiere matiere = mSrv.getById(mr.getId());

        fmSrv.insert(new FormateurMatiere(matiere, formateur));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id) {
        fSrv.deleteById(id);
        if (fSrv.getById(id) == null) {
            Utilisateur utilisateur = uSrv.getByRoleAndIdRole(Role.ROLE_FORMATEUR, id);
            uSrv.delete(utilisateur);
        }
    }

    @DeleteMapping("/{id_f}/{id_m}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteFromFormateur(@PathVariable("id_f") Integer idF, @PathVariable("id_m") Integer idM) {
        fmSrv.deleteById(new FormateurMatiereKey(idM, idF));
    }
}
