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

import com.example.demo.dto.request.GestionnaireRequest;
import com.example.demo.dto.response.GestionnaireResponse;
import com.example.demo.model.Gestionnaire;
import com.example.demo.service.GestionnaireService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/gestionnaire")
// @SecurityRequirement(name="basicAuth")
@CrossOrigin(origins = "*")
public class GestionnaireRestController {

	@Autowired
    private GestionnaireService gSrv;


    @GetMapping("/{id}")
	// @JsonView(CustomJsonViews.StagaireWithFiliere.class)
	public GestionnaireResponse getById(@PathVariable Integer id) {
		return new GestionnaireResponse(gSrv.getById(id), false);
	}

    @GetMapping("")
    // @JsonView(CustomJsonViews.Common.class)
    public List<GestionnaireResponse> getAll() {
        return gSrv.getAll().stream().map(gestionnaire -> new GestionnaireResponse(gestionnaire, false))
                            .collect(Collectors.toList());
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    // @JsonView(CustomJsonViews.Common.class)
    public GestionnaireResponse create(@Valid @RequestBody GestionnaireRequest gr, BindingResult br)  {
        if (br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Gestionnaire gestionnaire = new Gestionnaire();
        BeanUtils.copyProperties(gr, gestionnaire);
        return new GestionnaireResponse(gSrv.insert(gestionnaire), false);
    }

    @PutMapping("/{id}")
    // @JsonView(CustomJsonViews.Common.class)
    public GestionnaireResponse update(@Valid @RequestBody GestionnaireRequest gr, BindingResult br, @PathVariable Integer id) {
        if (br.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Gestionnaire gestionnaire = gSrv.getById(id);
        BeanUtils.copyProperties(gr, gestionnaire);
        return new GestionnaireResponse(gSrv.update(gestionnaire), false);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Integer id){
        gSrv.deleteById(id);
    }
}
