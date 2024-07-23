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
import com.example.demo.dto.request.IndisponibiliteRequest;
import com.example.demo.dto.response.IndisponibiliteResponse;
import com.example.demo.model.Indisponibilite;
import com.example.demo.service.FormateurService;
import com.example.demo.service.IndisponibiliteService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/indisponibilite")
@SecurityRequirement(name = "basicAuth")
@CrossOrigin(origins = "*")
public class IndisponibiliteRestController {

    @Autowired
    private IndisponibiliteService iSrv;

    @Autowired
    private FormateurService fSrv;

    @GetMapping("")
    @JsonView(CustomJsonViews.Common.class)
    public List<IndisponibiliteResponse> getAll() {
        return iSrv.getAll().stream().map(indisponibilite -> new IndisponibiliteResponse(indisponibilite))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public IndisponibiliteResponse getById(@PathVariable Integer id) {
        return new IndisponibiliteResponse(iSrv.getById(id));
    }

    @GetMapping("/formateur")
    @JsonView(CustomJsonViews.IndispoWithFormateur.class)
    public List<IndisponibiliteResponse> getAllWithFormateur() {
        return iSrv.getAllWithFormateur().stream()
                .map(indisponibilite -> new IndisponibiliteResponse(indisponibilite, true))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/formateur")
    @JsonView(CustomJsonViews.IndispoWithFormateur.class)
    public IndisponibiliteResponse getWithFormateur(@PathVariable Integer id) {
        return new IndisponibiliteResponse(iSrv.getWithFormateur(id), true);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(CustomJsonViews.Common.class)
    public IndisponibiliteResponse create(@Valid @RequestBody IndisponibiliteRequest ir, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Indisponibilite indisponibilite = new Indisponibilite();
        BeanUtils.copyProperties(ir, indisponibilite);
        indisponibilite.setFormateur(fSrv.getById(ir.getFormateur()));
        return new IndisponibiliteResponse(iSrv.insert(indisponibilite));
    }

    @PutMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public IndisponibiliteResponse update(@Valid @RequestBody IndisponibiliteRequest ir, BindingResult br,
            @PathVariable Integer id) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Indisponibilite indisponibilite = iSrv.getById(id);
        BeanUtils.copyProperties(ir, indisponibilite);
        indisponibilite.setFormateur(fSrv.getById(ir.getFormateur()));
        return new IndisponibiliteResponse(iSrv.update(indisponibilite));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id) {
        iSrv.deleteById(id);
    }
}
