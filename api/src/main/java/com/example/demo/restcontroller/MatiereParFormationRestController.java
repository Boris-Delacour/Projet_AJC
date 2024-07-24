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
import com.example.demo.dto.request.MatiereParFormationRequest;
import com.example.demo.dto.response.MatiereParFormationResponse;
import com.example.demo.model.MatiereParFormation;
import com.example.demo.service.FormateurService;
import com.example.demo.service.FormationService;
import com.example.demo.service.MatiereParFormationService;
import com.example.demo.service.MatiereService;
import com.example.demo.service.SalleService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/matiereparformation")
@CrossOrigin(origins = "*")
public class MatiereParFormationRestController {

	@Autowired
	private MatiereParFormationService matiereparformationSrv;
	@Autowired
	private MatiereService matSrv;
	@Autowired
	private FormationService formationSrv;
	@Autowired
	private FormateurService formateurSrv;
	@Autowired
	private SalleService salleSrv;

	@GetMapping("")
	@JsonView(CustomJsonViews.Common.class)
	public List<MatiereParFormationResponse> getAll() {
		return matiereparformationSrv.getAll().stream()
				.map(matiereparformation -> new MatiereParFormationResponse(matiereparformation, false))
				.collect(Collectors.toList());
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(CustomJsonViews.Common.class)
	public MatiereParFormationResponse create(@Valid @RequestBody MatiereParFormationRequest matiereparformationRequest,
			BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		MatiereParFormation matiereparformation = new MatiereParFormation();
		BeanUtils.copyProperties(matiereparformationRequest, matiereparformation);
		matiereparformation.setFormateur(formateurSrv.getById(matiereparformationRequest.getIdFormateur()));
		matiereparformation.setMatiere(matSrv.getById(matiereparformationRequest.getIdMatiere()));
		matiereparformation.setFormation(formationSrv.getById(matiereparformationRequest.getIdFormation()));
		matiereparformation.setSalle(salleSrv.getById(matiereparformationRequest.getIdSalle()));
		return new MatiereParFormationResponse(matiereparformationSrv.insert(matiereparformation), false);
	}

	@GetMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public MatiereParFormationResponse getById(@PathVariable Integer id) {
		return new MatiereParFormationResponse(matiereparformationSrv.getById(id), false);
	}

	@GetMapping("/{id}/all")
	@JsonView(CustomJsonViews.MatiereParFormationWithAll.class)
	public MatiereParFormationResponse getByIdWithAll(@PathVariable Integer id) {
		return new MatiereParFormationResponse(matiereparformationSrv.getByIdWithAll(id), true);
	}

	@PutMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public MatiereParFormationResponse update(@Valid @RequestBody MatiereParFormationRequest matiereparformationRequest,
			BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		MatiereParFormation matiereparformation = matiereparformationSrv.getById(id);
		BeanUtils.copyProperties(matiereparformationRequest, matiereparformation);
		matiereparformation.setFormateur(formateurSrv.getById(matiereparformationRequest.getIdFormateur()));
		matiereparformation.setMatiere(matSrv.getById(matiereparformationRequest.getIdMatiere()));
		matiereparformation.setFormation(formationSrv.getById(matiereparformationRequest.getIdFormation()));
		matiereparformation.setSalle(salleSrv.getById(matiereparformationRequest.getIdSalle()));
		matiereparformation.setId(id);
		return new MatiereParFormationResponse(matiereparformationSrv.insert(matiereparformation), false);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Integer id) {
		matiereparformationSrv.deleteById(id);
	}
}
