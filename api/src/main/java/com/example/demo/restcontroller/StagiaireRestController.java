package com.example.demo.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.StagiaireRequest;
import com.example.demo.dto.response.StagiaireResponse;
import com.example.demo.service.FormationService;
import com.example.demo.service.StagiaireService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stagiaire")
@SecurityRequirement(name="basicAuth")
public class StagiaireRestController {
	
	@Autowired
	private StagiaireService stagiaireSrv;
	@Autowired
	private FormationService formationSrv;
	
	@GetMapping("/{id}")
	//@JsonView(CustomJsonViews.StagiaireWithFormateur.class)
	public StagiaireResponse getById(@PathVariable Integer id) {
		return new StagiaireResponse(stagiaireSrv.getById(id));
	}
		
	@GetMapping("")
	public List<StagiaireResponse> getAll() {
		return stagiaireSrv.getAll().stream().map(model -> new StagiaireResponse(model)).collect(Collectors.toList());
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public StagiaireResponse create(@Valid @RequestBody StagiaireRequest stagiaireRequest,) {
		return
	}
	

}
