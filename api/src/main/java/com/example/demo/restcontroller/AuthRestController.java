package com.example.demo.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.jsonview.CustomJsonViews;
import com.example.demo.dto.response.UtilisateurResponse;
import com.example.demo.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/auth")
@SecurityRequirement(name = "basicAuth")
@CrossOrigin(origins = "*")
public class AuthRestController {

    @JsonView(CustomJsonViews.Common.class)
    @GetMapping("")
    public UtilisateurResponse authentication(@AuthenticationPrincipal Utilisateur utilisateur) {
        return new UtilisateurResponse(utilisateur);
    }
}
