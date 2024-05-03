package com.example.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HelloController {

	@Autowired
	private PokemonServiceImplementation pokeService;

	@Autowired
	private ItemServiceImplementation itemService;

	@Autowired
	private UserServiceImplementation userservice;

	
	@Autowired
	private SalesServiceImplementation salesService;

	@GetMapping("/")
	public String index() {

		return "Testing from Spring Boot!";
	}

	@GetMapping("/pokepoke")
	public List<Pokemon> pokemon_information() {
		return this.pokeService.getPokemonData();
	}

	@GetMapping("/allitems")
	public List<Items> item_information() {
		return this.itemService.getItemData();
	}

	@GetMapping("/first_pokemon")
	public String first_pokemon() {
		return this.pokeService.getPokemonName("1");
	}

	@GetMapping("/search")
	public List<Pokemon> searchPokemon(@RequestParam String name) {
		return this.pokeService.searchPokemonByName(name);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestParam String user, @RequestParam String pass) {
		try {
			this.userservice.addUser(user, pass);
			return ResponseEntity.ok("User registered.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody String user, @RequestParam String pass) {
		try {
			boolean loggedIn = this.userservice.loginUser(user, pass);
			if (loggedIn) {
				return ResponseEntity.ok("User logged in.");
			} else {
				return ResponseEntity.status(401).body("Login failed: Invalid username or password");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
		}
	}

	// public ResponseEntity<?> postMethodName(@RequestBody String user, @RequestParam String pass) {


	@PostMapping("/getUserSales")
	public List<Sales> userSales(@RequestBody String username) {
		return this.salesService.getUserPurchases(username);
	}

	@PostMapping("/getUserPurchases")
	public List<Sales> userPurchases(@RequestBody String username) {
		return this.salesService.getUserPurchases(username);
	}

	@PostMapping("/getUserTransactions")
	public List<Sales> userTransactions(@RequestBody String username) {
		return this.salesService.getUserSales(username);
	}

	@PostMapping("/addSale")
	public ResponseEntity<?> addSale(@RequestBody String buyer, String seller, @RequestParam float price) {
		try {
			boolean madeSale = this.salesService.addSale(seller, buyer, price);
			if (madeSale) {
				return ResponseEntity.ok("Sale added.");
			} else {
				return ResponseEntity.status(401).body("Transaction failed: Invalid sale attributes.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
		}
	}

}