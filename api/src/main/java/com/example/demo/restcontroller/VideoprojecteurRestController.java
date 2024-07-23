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
import com.example.demo.dto.request.VideoprojecteurRequest;
import com.example.demo.dto.response.VideoprojecteurResponse;
import com.example.demo.model.Videoprojecteur;
import com.example.demo.service.VideoprojecteurService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/videoprojecteur")
// @SecurityRequirement(name="basicAuth")
@CrossOrigin(origins = "*")
public class VideoprojecteurRestController {

    @Autowired
    private VideoprojecteurService videoprojecteurSrv;

    @GetMapping("")
    @JsonView(CustomJsonViews.Common.class)
    @Operation(summary = "Tout les videoprojecteurs")
    public List<VideoprojecteurResponse> getAll() {
        return videoprojecteurSrv.getAll().stream().map(videoprojecteur -> new VideoprojecteurResponse(videoprojecteur))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public VideoprojecteurResponse getById(@PathVariable Integer id) {
        return new VideoprojecteurResponse(videoprojecteurSrv.getById(id));
    }

    @GetMapping("marque/{marque}")
    @JsonView(CustomJsonViews.Common.class)
    public List<VideoprojecteurResponse> getByMarque(@PathVariable String marque) {
        return videoprojecteurSrv.getByMarque(marque).stream()
                .map(videoprojecteur -> new VideoprojecteurResponse(videoprojecteur))
                .collect(Collectors.toList());
    }

    @GetMapping("/fonctionnel")
    @JsonView(CustomJsonViews.Common.class)
    public List<VideoprojecteurResponse> getByFonctionnel() {
        return videoprojecteurSrv.getByFonctionnelTrue().stream()
                .map(videoprojecteur -> new VideoprojecteurResponse(videoprojecteur))
                .collect(Collectors.toList());
    }

    @GetMapping("/non-fontionnel")
    @JsonView(CustomJsonViews.Common.class)
    public List<VideoprojecteurResponse> getByNonFonctionnel() {
        return videoprojecteurSrv.getByFonctionnelFalse().stream()
                .map(videoprojecteur -> new VideoprojecteurResponse(videoprojecteur))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/salle")
    @JsonView(CustomJsonViews.VideoprojecteurWithSalle.class)
    public Videoprojecteur getWithSalle(@PathVariable Integer id) {
        return videoprojecteurSrv.getWithSalle(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(CustomJsonViews.Common.class)
    public VideoprojecteurResponse create(@Valid @RequestBody VideoprojecteurRequest videoprojecteurRequest,
            BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Videoprojecteur videoprojecteur = new Videoprojecteur();
        BeanUtils.copyProperties(videoprojecteurRequest, videoprojecteur);
        return new VideoprojecteurResponse(videoprojecteurSrv.insert(videoprojecteur), false);
    }

    @PutMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public VideoprojecteurResponse update(@Valid @RequestBody VideoprojecteurRequest videoprojecteurRequest,
            BindingResult br,
            @PathVariable Integer id) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Videoprojecteur videoprojecteur = videoprojecteurSrv.getById(id);
        BeanUtils.copyProperties(videoprojecteurRequest, videoprojecteur);
        videoprojecteur.setId((id));
        return new VideoprojecteurResponse(videoprojecteurSrv.update(videoprojecteur), false);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id) {
        videoprojecteurSrv.deleteById(id);
    }

}
