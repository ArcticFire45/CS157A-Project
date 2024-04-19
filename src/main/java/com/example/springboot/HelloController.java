package com.example.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.springboot.PokemonServiceImplementation;

@RestController
public class HelloController {

	@Autowired
	private PokemonServiceImplementation pokeservice;
	
	@GetMapping("/")
	public String index() {

		return "Testing from Spring Boot!";
	}
	@GetMapping("/pokepoke")
	public List<Pokemon> pokemon_information() {
		return this.pokeservice.getPokemonData();
	}

}