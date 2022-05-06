package br.com.bmfsolutions.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping(path = {"hello", "/"})
	public String hello() {
		return "<h1 style='color: darkcyan'>Hello Word!!</h1>";
	}
}
