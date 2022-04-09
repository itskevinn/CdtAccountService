package com.kevcode.cdtsaccountservice.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SwaggerMappingController {

    @RequestMapping("/api/swagger-ui.html")
    public String greeting() {
        return "redirect:/swagger-ui.html";
    }
}