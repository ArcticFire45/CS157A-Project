package com.example.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private UserPostsServiceImplementation userPostsService;

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
	public ResponseEntity<?> postMethodName(@RequestBody String user, @RequestParam String pass) {
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

	@GetMapping("/userposts")
    public List<UserPosts> getAllUserPosts() {
        return this.userPostsService.getAllUserPosts();
    }

    @PostMapping("/createuserpost")
    public ResponseEntity<?> createUserPost(@RequestBody UserPosts post) {
        try {
            this.userPostsService.createPokemonPost(post);
            return ResponseEntity.ok("User post created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to create user post: " + e.getMessage());
        }
    }


    @DeleteMapping("/userposts/{postId}")
    public ResponseEntity<?> deleteUserPost(@PathVariable Integer postId) {
        try {
            userPostsService.deletePokemonPost(postId);
            return ResponseEntity.ok("User post deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete user post: " + e.getMessage());
        }
    }
	



}