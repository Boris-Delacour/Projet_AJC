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
import com.example.demo.dto.request.TechnicienRequest;
import com.example.demo.dto.response.TechnicienResponse;
import com.example.demo.model.Technicien;
import com.example.demo.service.TechnicienService;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/technicien")
@CrossOrigin(origins = "*")
public class TechnicienRestController {

	@Autowired
	private TechnicienService tSrv;

	@GetMapping("")
	@JsonView(CustomJsonViews.Common.class)
	public List<TechnicienResponse> getAll() {
		return tSrv.getAll().stream().map(t -> new TechnicienResponse(t)).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public TechnicienResponse getById(@PathVariable("id") Integer id) {
		return new TechnicienResponse(tSrv.getById(id));
	}

	@PostMapping("")
	@JsonView(CustomJsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TechnicienResponse create(@RequestBody TechnicienRequest tr) {
		Technicien t = new Technicien();
		BeanUtils.copyProperties(tr, t);
		return new TechnicienResponse(tSrv.insert(t));

	}

	@PutMapping("/{id}")
	@JsonView(CustomJsonViews.Common.class)
	public TechnicienResponse update(@Valid @RequestBody TechnicienRequest tr, BindingResult br,
			@PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		Technicien technicien = tSrv.getById(id);
		BeanUtils.copyProperties(tr, technicien);
		technicien.setId(id);
		return new TechnicienResponse(tSrv.update(technicien));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Integer id) {
		tSrv.deleteById(id);
	}

}
