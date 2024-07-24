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
import com.example.demo.dto.request.OrdinateurRequest;
import com.example.demo.dto.response.OrdinateurResponse;
import com.example.demo.model.Ordinateur;
import com.example.demo.service.OrdinateurService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordinateur")
// @SecurityRequirement(name="basicAuth")
@CrossOrigin(origins = "*")
public class OrdinateurRestController {

    @Autowired
    private OrdinateurService ordinateurSrv;

    @GetMapping("")
    @JsonView(CustomJsonViews.Common.class)
    @Operation(summary = "Tout les ordinateurs")
    public List<OrdinateurResponse> getAll() {
        return ordinateurSrv.getAll().stream().map(ordinateur -> new OrdinateurResponse(ordinateur))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public OrdinateurResponse getById(@PathVariable Integer id) {
        return new OrdinateurResponse(ordinateurSrv.getById(id));
    }

    @GetMapping("marque/{marque}")
    @JsonView(CustomJsonViews.Common.class)
    public List<OrdinateurResponse> getByMarque(@PathVariable String marque) {
        return ordinateurSrv.getByMarque(marque).stream().map(ordinateur -> new OrdinateurResponse(ordinateur))
                .collect(Collectors.toList());
    }

    @GetMapping("os/{os}")
    @JsonView(CustomJsonViews.Common.class)
    public List<OrdinateurResponse> getByOs(@PathVariable String os) {
        return ordinateurSrv.getByOs(os).stream().map(ordinateur -> new OrdinateurResponse(ordinateur))
                .collect(Collectors.toList());
    }

    @GetMapping("/fonctionnel")
    @JsonView(CustomJsonViews.Common.class)
    public List<OrdinateurResponse> getByFonctionnel() {
        return ordinateurSrv.getByFonctionnelTrue().stream().map(ordinateur -> new OrdinateurResponse(ordinateur))
                .collect(Collectors.toList());
    }

    @GetMapping("/non-fontionnel")
    @JsonView(CustomJsonViews.Common.class)
    public List<OrdinateurResponse> getByNonFonctionnel() {
        return ordinateurSrv.getByFonctionnelFalse().stream().map(ordinateur -> new OrdinateurResponse(ordinateur))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/stagiaire")
    @JsonView(CustomJsonViews.OrdinateurWithStagiaire.class)
    public OrdinateurResponse getWithStagiaire(@PathVariable Integer id) {
        return new OrdinateurResponse(ordinateurSrv.getWithStagiaire(id), true);
    }
    
    @GetMapping("/available")
    @JsonView(CustomJsonViews.Common.class)
    public List<OrdinateurResponse> getAvailableAndFonctionnel() {
        return ordinateurSrv.getAvailableAndFonctionnel().stream().map(ordinateur -> new OrdinateurResponse(ordinateur))
                .collect(Collectors.toList());
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(CustomJsonViews.Common.class)
    public OrdinateurResponse create(@Valid @RequestBody OrdinateurRequest ordinateurRequest, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Ordinateur ordinateur = new Ordinateur();
        BeanUtils.copyProperties(ordinateurRequest, ordinateur);
        System.out.println(ordinateurRequest.getMarque());
        return new OrdinateurResponse(ordinateurSrv.insert(ordinateur), false);
    }

    @PutMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public OrdinateurResponse update(@Valid @RequestBody OrdinateurRequest ordinateurRequest, BindingResult br,
            @PathVariable Integer id) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Ordinateur ordinateur = ordinateurSrv.getById(id);
        BeanUtils.copyProperties(ordinateurRequest, ordinateur);
        ordinateur.setId((id));
        return new OrdinateurResponse(ordinateurSrv.update(ordinateur), false);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id) {
        ordinateurSrv.deleteById(id);
    }

}
