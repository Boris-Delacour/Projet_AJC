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
import com.example.demo.dto.request.FormateurRequest;
import com.example.demo.dto.request.MatiereRequest;
import com.example.demo.dto.response.MatiereResponse;
import com.example.demo.model.Formateur;
import com.example.demo.model.FormateurMatiere;
import com.example.demo.model.FormateurMatiereKey;
import com.example.demo.model.Matiere;
import com.example.demo.service.FormateurMatiereService;
import com.example.demo.service.FormateurService;
import com.example.demo.service.MatiereService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/matiere")
@SecurityRequirement(name = "basicAuth")
@CrossOrigin(origins = "*")
public class MatiereRestController {

	@Autowired
	private MatiereService mSrv;

	@Autowired
	private FormateurService fSrv;

	@Autowired
	private FormateurMatiereService fmSrv;

	@GetMapping("")
	@JsonView(CustomJsonViews.Common.class)
	public List<MatiereResponse> getAll() {
		return mSrv.getAll().stream().map(matiere -> new MatiereResponse(matiere))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public MatiereResponse getById(@PathVariable Integer id) {
		return new MatiereResponse(mSrv.getById(id));
	}

	@GetMapping("/{id}/formateur")
	@JsonView(CustomJsonViews.MatiereWithAll.class)
	public MatiereResponse getWithFormateur(@PathVariable Integer id) {
		return new MatiereResponse(mSrv.getWithFormateurs(id), true);
	}

	@GetMapping("/{id}/matiereParFormation")
	@JsonView(CustomJsonViews.MatiereWithAll.class)
	public MatiereResponse getWithMatiereParFormation(@PathVariable Integer id) {
		return new MatiereResponse(mSrv.getWithMatiereParFormation(id), true);
	}

	@GetMapping("/{id}/all")
	@JsonView(CustomJsonViews.MatiereWithAll.class)
	public MatiereResponse getWithAll(@PathVariable Integer id) {
		return new MatiereResponse(mSrv.getWithAll(id), true);
	}

	@GetMapping("/withoutformateur/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public List<MatiereResponse> getWithoutFormateur(@PathVariable Integer id) {
		Formateur formateur = fSrv.getById(id);
		return mSrv.getWithoutFormateur(formateur).stream().map(matiere -> new MatiereResponse(matiere))
				.collect(Collectors.toList());
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MatiereResponse create(@Valid @RequestBody MatiereRequest mr, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Matiere matiere = new Matiere();
		BeanUtils.copyProperties(mr, matiere);
		return new MatiereResponse(mSrv.insert(matiere));
	}

	@PutMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public MatiereResponse update(@Valid @RequestBody MatiereRequest mr, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Matiere matiere = mSrv.getById(id);
		BeanUtils.copyProperties(mr, matiere, "id");
		return new MatiereResponse(mSrv.update(matiere));
	}

	@PutMapping("/{id}/formateur")
	@JsonView(CustomJsonViews.Common.class)
	public void addFormateur(@Valid @RequestBody FormateurRequest fr, BindingResult br,
			@PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Matiere matiere = mSrv.getWithAll(id);
		Formateur formateur = fSrv.getById(fr.getId());

		fmSrv.insert(new FormateurMatiere(matiere, formateur));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Integer id) {
		mSrv.deleteById(id);
	}

	@DeleteMapping("/{id_m}/{id_f}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteFromFormateur(@PathVariable("id_m") Integer idM, @PathVariable("id_f") Integer idF) {
		fmSrv.deleteById(new FormateurMatiereKey(idM, idF));
	}
}
