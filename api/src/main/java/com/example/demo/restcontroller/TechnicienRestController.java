package com.example.demo.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.TechnicienRequest;
import com.example.demo.dto.response.TechnicienResponse;
import com.example.demo.model.Technicien;
import com.example.demo.service.TechnicienService;

	
	@RestController
	@RequestMapping("/api/technicien")
	public class TechnicienRestController {

		@Autowired
		private TechnicienService technicienSrv;

		@GetMapping("")
		public List<TechnicienResponse> getAll() {
			return technicienSrv.getAll().stream().map(t -> new TechnicienResponse(t)).collect(Collectors.toList());
		}

		@PostMapping("")
		@ResponseStatus(code = HttpStatus.CREATED)
		public TechnicienResponse create(@RequestBody TechnicienRequest technicienRequest) {
			Technicien t = new Technicien();
			BeanUtils.copyProperties(technicienRequest, t);
			return new TechnicienResponse(technicienSrv.insert(t));
		
	}
}
