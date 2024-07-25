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
import com.example.demo.dto.request.SalleRequest;
import com.example.demo.dto.response.SalleResponse;
import com.example.demo.model.Salle;
import com.example.demo.service.SalleService;
import com.example.demo.service.VideoprojecteurService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/salle")
@SecurityRequirement(name = "basicAuth")
@CrossOrigin(origins = "*")
public class SalleRestController {

    @Autowired
    private SalleService salleSrv;

    @Autowired
    private VideoprojecteurService VideoprojecteurSrv;

    @GetMapping("")
    @JsonView(CustomJsonViews.Common.class)
    @Operation(summary = "Toutes les salles")
    public List<SalleResponse> getAll() {
        return salleSrv.getAll().stream().map(salle -> new SalleResponse(salle))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public SalleResponse getById(@PathVariable Integer id) {
        return new SalleResponse(salleSrv.getById(id));
    }

    @GetMapping("/occupees")
    @JsonView(CustomJsonViews.Common.class)
    @Operation(summary = "Tout les salles occupées")
    public List<SalleResponse> getByOccupe() {
        return salleSrv.getByOccuperTrue().stream().map(salle -> new SalleResponse(salle))
                .collect(Collectors.toList());
    }

    @GetMapping("/libres")
    @JsonView(CustomJsonViews.Common.class)
    @Operation(summary = "Tout les salles libres")
    public List<SalleResponse> getByLibre() {
        return salleSrv.getByOccuperFalse().stream().map(salle -> new SalleResponse(salle))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/videoprojecteur")
    @JsonView(CustomJsonViews.SalleWithVideoprojecteur.class)
    public SalleResponse getWithVideoprojecteur(@PathVariable("id") Integer id) {
        return new SalleResponse(salleSrv.getWithVideoprojecteur(id));
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(CustomJsonViews.Common.class)
    public SalleResponse create(@Valid @RequestBody SalleRequest salleRequest,
            BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Salle salle = new Salle();
        BeanUtils.copyProperties(salleRequest, salle);
        salle.setVideoprojecteur(VideoprojecteurSrv.getById(salleRequest.getIdVideoprojecteur()));
        return new SalleResponse(salleSrv.insert(salle), false);
    }

    @PutMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public SalleResponse update(@Valid @RequestBody SalleRequest salleRequest,
            BindingResult br,
            @PathVariable Integer id) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Salle salle = salleSrv.getById(id);
        BeanUtils.copyProperties(salleRequest, salle);
        salle.setVideoprojecteur(VideoprojecteurSrv.getById(salleRequest.getIdVideoprojecteur()));
        salle.setId((id));
        return new SalleResponse(salleSrv.update(salle), false);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id) {
        salleSrv.deleteById(id);
    }

}
