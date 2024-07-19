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

import com.example.demo.dto.request.FormateurRequest;
import com.example.demo.dto.response.FormateurResponse;
import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.model.Formateur;
import com.example.demo.service.FormateurService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/formateur")
// @SecurityRequirement(name="basicAuth")
@CrossOrigin(origins = "*")
public class FormateurRestController {

    @Autowired
    private FormateurService fSrv;

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

	@GetMapping("/{id}/matieres")
	@JsonView(CustomJsonViews.FormateurWithMatiere.class)
	public FormateurResponse getByFormateurWithMatieres(@PathVariable Integer id) {
		return new FormateurResponse(fSrv.getWithMatieres(id), true);
	}

	@GetMapping("/{id}/indisponibilites")
	@JsonView(CustomJsonViews.FormateurWithMatiere.class)
	public FormateurResponse getByFormateurWithIndisponibilites(@PathVariable Integer id) {
		return new FormateurResponse(fSrv.getWithMatieres(id), true);
	}

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    @JsonView(CustomJsonViews.Common.class)
    public FormateurResponse create(@Valid @RequestBody FormateurRequest fr, BindingResult br)  {
        if (br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Formateur formateur = new Formateur();
        BeanUtils.copyProperties(fr, formateur);
        return new FormateurResponse(fSrv.insert(formateur));
    }
    
    @PutMapping("/{id}")
    @JsonView(CustomJsonViews.Common.class)
    public FormateurResponse update(@Valid @RequestBody FormateurRequest fr, BindingResult br, @PathVariable Integer id) {
        if (br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Formateur formateur = fSrv.getById(id);
        BeanUtils.copyProperties(fr, formateur);
        return new FormateurResponse(fSrv.update(formateur));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id){
        fSrv.deleteById(id);
    }
}
