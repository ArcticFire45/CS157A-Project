package com.example.springboot;

// import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@Autowired
	private ItemSalesServiceImplementation itemSalesService;

	@Autowired
	private PokemonSalesServiceImplementation pokemonSalesService;

	@GetMapping("/")
	public String index() {

		return "Testing from Spring Boot!";
	}

	// Returns all Pokemon template data
	@GetMapping("/pokepoke")
	public List<Pokemon> pokemon_information() {
		return this.pokeService.getPokemonData();
	}
	// Returns all item template data
	@GetMapping("/allitems")
	public List<Items> item_information() {
		return this.itemService.getItemData();
	}
	// Retrieves a specific item template by its template ID
	@GetMapping("/getItem")
	public Items getItem(@RequestParam String item_template_id) {
		return this.itemService.getItem(item_template_id);
	}

	// Retrieves the first pokemon template
	@GetMapping("/first_pokemon")
	public String first_pokemon() {
		return this.pokeService.getPokemonName("1");
	}

	// Retrieves a specific pokemon template by its template ID
	@GetMapping("/getPokemon")
	public Pokemon getPokemon(@RequestParam String pokemon_template_id) {
		return this.pokeService.getPokemon(pokemon_template_id);
	}
	// Retrieves a list of pokemon template that contain the name's value in their name
	@GetMapping("/search")
	public List<Pokemon> searchPokemon(@RequestParam String name) {
		return this.pokeService.searchPokemonByName(name);
	}
	// Retrieves a list of pokemon template that contain the name's value in their name
	@GetMapping("/itemsearch")
	public List<Items> searchItem(@RequestParam String name) {
		return this.itemService.searchItemByName(name);
	}
	// Saves user in database
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
	// Retrieves user account information given username
	@GetMapping("/user")
	public User getUser(@RequestParam String username) {
		return this.userservice.getUserFrom(username);
	}

	@GetMapping("/alluser/{excludedUsername}")
	public List<String> getAllUserExcept(@PathVariable String excludedUsername) {
		return this.userservice.getAllUsernamesExcept(excludedUsername);
	}
	// Adds money to the user's account 
	@PostMapping("/updateMoney")
	public void updateMoney(@RequestBody Map<String, Object> requestBody) {
		String username = (String) requestBody.get("username");
		double moneyToAdd = (double) requestBody.get("moneyToAdd");
		this.userservice.updateUserMoney(username, moneyToAdd);
	}
	// Retrieves all sales that a user has sold.
	@GetMapping("/getUserSales")
	public List<Sales> userSales(@RequestParam String username) {
		return this.salesService.getUserPurchases(username);
	}
	// Retrieves all sales that a user has purchased
	@GetMapping("/getUserPurchases")
	public List<Sales> userPurchases(@RequestParam String username) {
		return this.salesService.getUserPurchases(username);
	}
	// Retrieves all sales that a user has sold
	@GetMapping("/getUserTransactions")
	public List<Sales> userTransactions(@RequestBody String username) {
		return this.salesService.getUserSales(username);
	}
	// Adds a sale to the database
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
	// Retrieves item that exists in circulation given the ID
	@GetMapping("/getExistingItem")
	public ExistingItem getExistingItem(@RequestParam String item_id) {
		try {
			return this.existingItemsService.getItem(item_id);
		} catch (Exception e) {
			return null;
		}
	}
	// Retrieves all items that exists in circulation from a user
	@GetMapping("/getExistingUserItems")
	public List<Items> getExistingUserItems(@RequestParam String username) {
		try {
			return this.existingItemsService.getUserItems(username);
		} catch (Exception e) {
			return null;
		}
	}

	// Retrieves all items that exists in circulation from a username and item template type
	@GetMapping("/getExistingItems")
	public List<ExistingItem> getExistingItems(@RequestParam String username, String template_id) {
		try {
			return this.existingItemsService.getExistingItems(username, template_id);
		} catch (Exception e) {
			return null;
		}
	}
	// Retrieves all items that exists in circulation from a template type
	@GetMapping("/getExistingTemplateItems")
	public List<ExistingItem> getExistingTemplateItem(@RequestParam String template_id) {
		try {
			return this.existingItemsService.getExistingTemplateItems(template_id);
		} catch (Exception e) {
			return null;
		}
	}
	// Retrieves all items that exists in circulation from a user that can be sold
	@GetMapping("/getUserSellableItems")
	public List<ExistingItem> getUserSellableItems(@RequestParam String username) {
		try {
			return this.existingItemsService.getUserSellableItems(username);
		} catch (Exception e) {
			return null;
		}
	}
	// Adds a new existing item into the database
	@PostMapping("/addExistingItem")
	public Boolean addExistingItem(@RequestParam String username, String template_id) {
		try {
			return this.existingItemsService.addExistingItem(username, template_id);
		} catch (Exception e) {
			return false;
		}

	}

	// Deletes an existing item from the database
	@PostMapping("/deleteExistingItem")
	public Boolean deleteExistingItem(@RequestParam String item_id) {
		try {
			return this.existingItemsService.deleteExistingItem(item_id);
		} catch (Exception e) {
			return false;
		}

	}
	
	// Updates the owner of an item to another username
	@PostMapping("/changeItemOwner")
	public Boolean changeItemOwner(@RequestParam String item_id, String new_username) {
		try {
			return this.existingItemsService.changeOwnerUsername(item_id, new_username);
		} catch (Exception e) {
			return false;
		}

	}

	//Retrieves a pokemon that exists given their pokemon id
	@GetMapping("/getExistingPokemon")
	public ExistingPokemon getExistingPokemon(@RequestParam String poke_id) {
		try {

			return this.existingPokemonService.getPokemon(poke_id);
		} catch (Exception e) {
			return null;
		}
	}
	//Retrieves all pokemon that exists from a user 
	@GetMapping("/getExistingUserPokemon")
	public List<Pokemon> getUserPokemon(@RequestParam String username) {
		try {
			return this.existingPokemonService.getUserPokemon(username);
		} catch (Exception e) {
			return null;
		}
	}

	//Retrieves all pokemon that exists that can be added to a sales post from a user 
	@GetMapping("/getUserSellablePokemon")
	public List<ExistingPokemon> getUserSellablePokemon(@RequestParam String username) {
		try {
			return this.existingPokemonService.getUserSellablePokemon(username);
		} catch (Exception e) {
			return null;
		}
	}

	//Retrieves all pokemon that exists of a template type from a user 
	@GetMapping("/getExistingPokemons")
	public List<ExistingPokemon> getExistingPokemon(@RequestParam String username, String template_id) {
		try {
			return this.existingPokemonService.getExistingPokemons(username, template_id);
		} catch (Exception e) {
			return null;
		}
	}
	//Retrieves all pokemon that exists of a template type
	@GetMapping("/getExistingTemplatePokemon")
	public List<ExistingPokemon> getExistingTemplatePokemon(@RequestParam String template_id) {
		try {
			return this.existingPokemonService.getExistingTemplatePokemon(template_id);
		} catch (Exception e) {
			return null;
		}
	}
	//Adds a new existing pokemon  
	@PostMapping("/addExistingPokemon")
	public Boolean addExistingPokemon(@RequestParam String username, String template_id) {
		try {
			return this.existingPokemonService.addExistingPokemon(username, template_id);
		} catch (Exception e) {
			return false;
		}

	}
	
	//Deletes an existing pokemon  
	@PostMapping("/deleteExistingPokemon")
	public Boolean deleteExistingPokemon(@RequestParam String poke_id) {
		try {
			return this.existingPokemonService.deleteExistingPokemon(poke_id);
		} catch (Exception e) {
			return false;
		}

	}

	//Changes the owner of the existing pokemon to the new username provided   
	@PostMapping("/changePokemonOwner")
	public Boolean changePokemonOwner(@RequestParam String poke_id, String new_username) {
		try {
			return this.existingPokemonService.changeOwnerUsername(poke_id, new_username);
		} catch (Exception e) {
			return false;
		}

	}

	//Adds a new frienship between two users  
	@PostMapping("/addFriend")
	public void addFriend(@RequestBody Map<String, Object> requestBody) {
		String currentUser = (String) requestBody.get("username1");
		String friendUser = (String) requestBody.get("username2");
		this.friendService.addFriend(currentUser, friendUser);
	}

	//Removes an existing friendship between two users  
	@PostMapping("/removeFriend")
	public void deleteFriendship(@RequestBody Map<String, Object> request) {
		String username1 = (String) request.get("username1");
		String username2 = (String) request.get("username2");
		this.friendService.removeFriend(username1, username2);
	}

	//checks to see if the two users are friends 
	@GetMapping("/checkFriendship")
	public boolean checkFriendship(@RequestParam String username1, @RequestParam String username2) {
		return this.friendService.checkFriendship(username1, username2);
	}

	//Retrieves all userposts that exist
	@GetMapping("/allPosts")
	public List<Posts> getAllPosts() {
		return this.postService.getAllPokemonPosts();
	}
	//Creates a new userpost
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
	//Deletes an existing userpost given the postID and username
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
	//Retrieves 6-team roster of a given user
	@GetMapping("/getRoster")
	public List<Integer> getRoster(@RequestParam String username) {
		try {
			return this.rosterService.getRoster(username);
		} catch (Exception e) {
			return null;
		}
	}
	// Adds a specific pokemon into the 6-team roster of the given user
	@PostMapping("/addToRoster")
	public boolean addToRoster(@RequestParam String username, @RequestParam Integer pokemonID) {
		try {
			return this.rosterService.addPokemonToRoster(username, pokemonID);
		} catch (Exception e) {
			return false;
		}
	}
	// Removes a specific pokemon into the 6-team roster of the given user
	@PostMapping("/deleteFromRoster")
	public boolean deleteFromRoster(@RequestParam String username, @RequestParam Integer pokemonID) {
		try {
			return this.rosterService.removePokemonFromRoster(username, pokemonID);
		} catch (Exception e) {
			return false;
		}
	}


	// Create a sales post for pokemon
	@PostMapping("/createPokemonSalesPost")
	public Boolean createPokemonSalesPost(@RequestParam String username, String postDesc, String imageURL, Float price, Integer pokemon_id) {
		try {
			return salesPostService.createSalesPostPokemon(new Posts(-1, username, postDesc, imageURL),
													new Sales(-1, username, price),
													pokemon_id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Create a sales post for pokemon
	@PostMapping("/createItemSalesPost")
	public Boolean createItemSalesPost(@RequestParam String username, String postDesc, String imageURL, Float price, Integer item_id) {
		try {
			return salesPostService.createSalesPostItem(new Posts(-1, username, postDesc, imageURL),
													new Sales(-1, username, price),
													item_id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Delete a sales post
	@DeleteMapping("/deleteSalesPost")
	public ResponseEntity<String> deleteSalesPost(@RequestParam Integer post_id, String username) {
		try {
			postService.deletePost(post_id, username);
			return ResponseEntity.ok("Sales post deleted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to delete sales post.");
		}
	}

	// Used to buy items from the shop
	@PostMapping("/buyShopItem")
	public boolean buyShopItem(@RequestParam String buyer_username, float price, Integer item_template_id) {
		try {
			return itemSalesService.buyStockItem(new Sales(-1, "", buyer_username, price), item_template_id);
		} catch (Exception e) {
			return false;
		}
	}

	// Used to buy items from other people. will do a transfer
	@PostMapping("/buySellerItem")
	public boolean buySellerItem(@RequestParam String seller_username, String buyer_username, float price,
			Integer existing_item_id) {
		try {
			return itemSalesService.buySellerItem(new Sales(-1, seller_username, buyer_username, price),
					existing_item_id);
		} catch (Exception e) {
			return false;
		}
	}

	// Used to buy items from the shop
	@PostMapping("/buyShopPokemon")
	public boolean buyShopPokemon(@RequestParam String buyer_username, float price, Integer pokemon_template_id) {
		try {
			return pokemonSalesService.buyStockPokemon(new Sales(-1, "", buyer_username, price), pokemon_template_id);
		} catch (Exception e) {
			return false;
		}
	}

	// Used to buy items from other people. will do a transfer
	@PostMapping("/buySellerPokemon")
	public boolean buySellerPokemon(@RequestParam String seller_username, String buyer_username, float price,
			Integer existing_pokemon_id) {
		try {
			return pokemonSalesService.buySellerPokemon(new Sales(-1, seller_username, buyer_username, price),
					existing_pokemon_id);
		} catch (Exception e) {
			return false;
		}
	}

}