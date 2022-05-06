package br.com.bmfsolutions.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

	@GetMapping("somar/{a}/{b}")
	public String Somar(@PathVariable int a, @PathVariable int b) {
		return String.format("%s + %s = %s", a, b, a+b);
	}
	
	@GetMapping("subtrair")
	public String subtrair(@RequestParam int a, @RequestParam int b) {
		return String.format("%s - %s = %s", a ,b , a-b);
	}
}
