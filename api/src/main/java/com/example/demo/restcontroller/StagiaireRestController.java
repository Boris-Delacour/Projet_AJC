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
import com.example.demo.dto.request.StagiaireRequest;
import com.example.demo.dto.response.StagiaireResponse;
import com.example.demo.model.Stagiaire;
import com.example.demo.service.FormationService;
import com.example.demo.service.OrdinateurService;
import com.example.demo.service.StagiaireService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stagiaire")
@SecurityRequirement(name = "basicAuth")
@CrossOrigin(origins = "*")
public class StagiaireRestController {

	@Autowired
	private StagiaireService stagiaireSrv;
	@Autowired
	private FormationService formationSrv;

	@Autowired
	private OrdinateurService ordinateurSrv;

	@GetMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public StagiaireResponse getById(@PathVariable Integer id) {
		return new StagiaireResponse(stagiaireSrv.getById(id));
	}

	@GetMapping("")
	@JsonView(CustomJsonViews.Common.class)
	public List<StagiaireResponse> getAll() {
		return stagiaireSrv.getAll().stream().map(model -> new StagiaireResponse(model)).collect(Collectors.toList());
	}

	@GetMapping("/{id}/formation")
	public StagiaireResponse getWithFormation(@PathVariable Integer id) {
		return new StagiaireResponse(stagiaireSrv.getWithFormation(id));
	}

	@GetMapping("/{id}/ordinateur")
	@JsonView(CustomJsonViews.StagiaireWithOrdinateur.class)
	public StagiaireResponse getWithOrdinateur(@PathVariable Integer id) {
		return new StagiaireResponse(stagiaireSrv.getWithOrdinateur(id));
	}
	
	@GetMapping("/{id}/all")
	@JsonView(CustomJsonViews.StagiaireWithAll.class)
	public StagiaireResponse getWithAll(@PathVariable Integer id) {
		return new StagiaireResponse(stagiaireSrv.getWithAll(id));
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(CustomJsonViews.Common.class)
	public StagiaireResponse create(@Valid @RequestBody StagiaireRequest stagiaireRequest, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Stagiaire model = new Stagiaire();
		BeanUtils.copyProperties(stagiaireRequest, model);
		model.setFormation(formationSrv.getById(stagiaireRequest.getIdFormation()));
		model.setOrdinateur(ordinateurSrv.getById(stagiaireRequest.getIdOrdinateur()));
		return new StagiaireResponse(stagiaireSrv.insert(model));
	}

	@PutMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public StagiaireResponse update(@Valid @RequestBody StagiaireRequest stagiaireRequest, BindingResult br,
			@PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Stagiaire model = new Stagiaire();
		BeanUtils.copyProperties(stagiaireRequest, model);
		model.setFormation(formationSrv.getById(stagiaireRequest.getIdFormation()));
		model.setOrdinateur(ordinateurSrv.getById(stagiaireRequest.getIdOrdinateur()));
		model.setId(id);
		return new StagiaireResponse(stagiaireSrv.update(model));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		stagiaireSrv.deleteById(id);
	}
}
