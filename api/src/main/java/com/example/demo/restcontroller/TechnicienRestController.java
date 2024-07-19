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

import com.example.demo.dto.request.TechnicienRequest;
import com.example.demo.dto.response.TechnicienResponse;
import com.example.demo.model.Technicien;
import com.example.demo.service.TechnicienService;
import com.example.demo.service.VideoprojecteurService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/technicien")
// @SecurityRequirement(name="basicAuth")
@CrossOrigin(origins = "*")
public class TechnicienRestController {

    @Autowired
    private TechnicienService technicienSrv;

    @GetMapping("")
    // @JsonView(CustomJsonViews.commun.class)
    @Operation(summary = "Tout les techniciens")
    public List<TechnicienResponse> getAll() {
        return technicienSrv.getAll().stream().map(technicien -> new TechnicienResponse(technicien))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    // @JsonView(CustomJsonViews.commun.class)
    public TechnicienResponse getById(@PathVariable Integer id) {
        return new TechnicienResponse(technicienSrv.getById(id));
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    // @JsonView(CustomJsonViews.commun.class)
    public TechnicienResponse create(@Valid @RequestBody TechnicienRequest technicienRequest,
            BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Technicien technicien = new Technicien();
        BeanUtils.copyProperties(technicienRequest, technicien);
        return new TechnicienResponse(technicienSrv.insert(technicien), false);
    }

    @PutMapping("/{id}")
    // @JsonView(CustomJsonViews.commun.class)
    public TechnicienResponse update(@Valid @RequestBody TechnicienRequest technicienRequest,
            BindingResult br,
            @PathVariable Integer id) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Technicien technicien = technicienSrv.getById(id);
        BeanUtils.copyProperties(technicienRequest, technicien);
        technicien.setId((id));
        return new TechnicienResponse(technicienSrv.update(technicien), false);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id) {
        technicienSrv.deleteById(id);
    }

}
