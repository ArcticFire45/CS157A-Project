package com.example.springboot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	private PokemonRosterImplementation rosterService;

	@Autowired
	private ExistingItemServiceImplementation existingItemsService;

	@Autowired
	private ExistingPokemonServiceImplementation existingPokemonService;

	@Autowired
	private FriendsServiceeImplementation friendService;

	@Autowired
	private PostsServiceImplementation postService;

	@Autowired
    private SalesPostServiceImplementation salesPostService;

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

	@GetMapping("/alluser/{excludedUsername}")
	public List<String> getAllUserExcept(@PathVariable String excludedUsername) {
		return this.userservice.getAllUsernamesExcept(excludedUsername);
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
	public List<Sales> userSales(@RequestParam String username) {
		return this.salesService.getUserPurchases(username);
	}

	@PostMapping("/getUserPurchases")
	public List<Sales> userPurchases(@RequestParam String username) {
		return this.salesService.getUserPurchases(username);
	}

	@PostMapping("/getUserTransactions")
	public List<Sales> userTransactions(@RequestBody String username) {
		return this.salesService.getUserSales(username);
	}

	@PostMapping("/addSale")
	public ResponseEntity<?> addSale(@RequestParam String buyer, String seller, float price) {
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

	@GetMapping("/allPosts")
	public List<Posts> getAllPosts() {
		return this.postService.getAllPokemonPosts();
	}

	@PostMapping("/createPost")
	public ResponseEntity<String> createPost(@RequestBody Posts post) {
		try {
			postService.createPokemonPost(post);
			return ResponseEntity.ok("Pokemon post created successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create pokemon post.");
		}
	}

	@DeleteMapping("/deletePost/{postId}/{authorUsername}")
	public ResponseEntity<String> deletePost(@PathVariable int postId, @PathVariable String authorUsername) {
		try {
			postService.deletePost(postId, authorUsername);
			return ResponseEntity.ok("Post deleted successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to delete post: " + e.getMessage());
		}
	}
	

	@PostMapping("/salesposts")
    public ResponseEntity<String> createSalesPost(@RequestBody SalesPost salesPost) {
        try {
            salesPostService.createSalesPost(salesPost);
            return ResponseEntity.ok("Sales post created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to create sales post.");
        }
    }

    @DeleteMapping("/salesposts/{salesId}")
    public ResponseEntity<String> deleteSalesPost(@RequestParam Integer salesId) {
        try {
            salesPostService.deleteSalesPost(salesId);
            return ResponseEntity.ok("Sales post deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to delete sales post.");
        }
    }



}