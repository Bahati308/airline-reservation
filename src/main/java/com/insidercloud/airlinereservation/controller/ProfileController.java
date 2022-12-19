package com.insidercloud.airlinereservation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Controller for requests to the {@code /profile} resource. Populates the model with the claims from the
 * {@linkplain OidcUser} for use by the view.
 */
@Controller
public class ProfileController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal OidcUser oidcUser) {
        model.addAttribute("profile", oidcUser.getClaims());
        return "profile";
    }

}