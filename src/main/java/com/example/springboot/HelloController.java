package com.example.springboot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
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

	@Autowired
	private ExistingItemServiceImplementation existingItemsService;

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

	@GetMapping("/itemsearch")
	public List<Items> searchItem(@RequestParam String name) {
		return this.itemService.searchItemByName(name);
	}

	@PostMapping(value = "/signup")
	public int signUp(@RequestBody User user) {
		return this.userservice.addUser(user);
	}

	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<?> login(@PathVariable("username") String user, @PathVariable("password") String pass) {
		boolean loggedIn = this.userservice.loginUser(user, pass);
		if (loggedIn) {
			User userData = this.userservice.getUserFrom(user);
			return ResponseEntity.ok(userData);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}
	}

	@GetMapping("/user")
	public User getUser(@RequestParam String username) {
		return this.userservice.getUserFrom(username);
	}

	@PostMapping("/updateMoney")
	public void updateMoney(@RequestBody Map<String, Object> requestBody) {
		String username = (String) requestBody.get("username");
		double moneyToAdd = (double) requestBody.get("moneyToAdd");
		this.userservice.updateUserMoney(username, moneyToAdd);
	}

	// public ResponseEntity<?> postMethodName(@RequestBody String user,
	// @RequestParam String pass) {

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
// getItem
// getUserItems
// getExistingItems
// getExistingTemplateItems


	@GetMapping("/getExistingItem")
	public ExistingItem getExistingItem(@RequestBody String item_id) {
		try {
			return this.existingItemsService.getItem(item_id);
			} catch (Exception e) {
			return null;
		}
	}


	@GetMapping("/getUserItems")
	public List<ExistingItem> getUserItems(@RequestBody String username) {
		try {
			return this.existingItemsService.getUserItems(username);
			} catch (Exception e) {
			return null;
		}
	}
	@GetMapping("/getExistingItems")
	public List<ExistingItem> getExistingItems(@RequestBody String username, String template_id) {
		try {
			return this.existingItemsService.getExistingItems(username, template_id);
			} catch (Exception e) {
			return null;
		}
	}


	@GetMapping("/getExistingTemplateItems")
	public  List<ExistingItem> getExistingTemplateItems(@RequestBody String template_id) {
		try {
			return this.existingItemsService.getExistingTemplateItems(template_id);
			} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/addExistingItem")
	public  Boolean getExistingTemplateItems(@RequestBody String username, String template_id) {
		try {
			return this.existingItemsService.addExistingItem(username, template_id);
			} catch (Exception e) {
			return false;
		}
	}


	
	

	

}