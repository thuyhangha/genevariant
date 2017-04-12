package com.hangha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneController {
	@RequestMapping("/oncogene")
    public String greeting() {
        return "{}";
    }
}
