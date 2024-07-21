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
import com.example.demo.dto.request.FormationRequest;
import com.example.demo.dto.response.FormationResponse;
import com.example.demo.model.Formation;
import com.example.demo.service.FormateurService;
import com.example.demo.service.FormationService;
import com.example.demo.service.GestionnaireService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/formation")
// @SecurityRequirement(name="basicAuth")
@CrossOrigin(origins = "*")
public class FormationRestController {

    @Autowired
    private GestionnaireService gSrv;

    @Autowired
    private FormationService foSrv;
    @Autowired
    private FormateurService fSrv;

    @GetMapping("")
    @JsonView(CustomJsonViews.Common.class)
    public List<FormationResponse> getAll() {
        return foSrv.getAll().stream().map(formation -> new FormationResponse(formation, false))
                            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public FormationResponse getById(@PathVariable Integer id) {
		return new FormationResponse(foSrv.getById(id), false);
	}

    @GetMapping("/{id}/formateurs")
	@JsonView(CustomJsonViews.FormationWithFormateur.class)
	public FormationResponse getWithFormateurs(@PathVariable("id") Integer id) {
		return new FormationResponse(foSrv.getWithFormateurs(id), true);
	}

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(CustomJsonViews.Common.class)
    public FormationResponse create(@Valid @RequestBody FormationRequest fr, BindingResult br)  {
        if (br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Formation formation = new Formation();
        BeanUtils.copyProperties(fr, formation);

        formation.setGestionnaire(gSrv.getById(fr.getIdGestionnaire()));
        formation.setFormateur(fSrv.getById(fr.getIdFormateur()));

        return new FormationResponse(foSrv.insert(formation), false);
    }

    @PutMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public FormationResponse update(@Valid @RequestBody FormationRequest fr, BindingResult br, @PathVariable Integer id) {
        if (br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Formation formation = foSrv.getById(id);
        BeanUtils.copyProperties(fr, formation);
        return new FormationResponse(foSrv.update(formation), false);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id){
        foSrv.deleteById(id);
    }
}
