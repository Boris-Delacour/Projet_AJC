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

import com.example.demo.dto.request.MatiereRequest;
import com.example.demo.dto.response.MatiereResponse;
import com.example.demo.model.Matiere;
import com.example.demo.service.MatiereService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/matiere")
@CrossOrigin(origins = "*")
public class MatiereRestController {

	@Autowired
	private MatiereService mSrv;

	@GetMapping("")
	public List<MatiereResponse> getAll() {
		return mSrv.getAll().stream().map(matiere -> new MatiereResponse(matiere))
							.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public MatiereResponse getById(@PathVariable Integer id) {
		return new MatiereResponse(mSrv.getById(id));
	}
	
	@GetMapping("/{id}/formateur")
	public MatiereResponse getWithFormateur(@PathVariable Integer id) {
		return new MatiereResponse(mSrv.getWithFormateurs(id), true);
	}

	@GetMapping("/{id}/matiereParFormation")
	public MatiereResponse getWithMatiereParFormation(@PathVariable Integer id) {
		return new MatiereResponse(mSrv.getWithMatiereParFormation(id), true);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public MatiereResponse create(@Valid @RequestBody MatiereRequest mr, BindingResult br) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Matiere matiere = new Matiere();
		BeanUtils.copyProperties(mr, matiere);
		return new MatiereResponse(mSrv.insert(matiere));
	}

	@PutMapping("/{id}")
	public MatiereResponse update(@Valid @RequestBody MatiereRequest mr, BindingResult br, @PathVariable Integer id) {
		if(br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Matiere matiere = mSrv.getById(id);
		BeanUtils.copyProperties(mr, matiere);
		return new MatiereResponse(mSrv.update(matiere));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Integer id) {
		mSrv.deleteById(id);
	}
}