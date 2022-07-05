package rest;

import db.*;
import db.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    RecipesRepo recipesRepo;
    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MealRepo mealRepo;
    @Autowired
    UserRecipesRepo userRecipesRepo;

    @PostMapping("/create")
    public ResponseEntity<String> createRecipe(@RequestBody Recipe recipe, @RequestParam Long userId) {
        try {
            recipe = recipesRepo.save(recipe);

            User user = userRepo.findById(userId).orElseThrow(Exception::new);
            Set<Recipe> recipes = user.getRecipes();
            recipes.add(recipe);
            user.setRecipes(recipes);
            userRepo.save(user);
            return ResponseEntity.ok().body(recipe.getId().toString());
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/add-products")
    public ResponseEntity<Object> createRecipe(@RequestBody List<Product> products, @RequestParam Long recipeId) {
        try {
            Recipe recipe = recipesRepo.findById(recipeId).orElseThrow(Exception::new);
            for (Product product : products) {
                Product existingProduct = productsRepo.findById(product.getId()).orElseThrow(Exception::new);
                recipe.getProducts().add(existingProduct);
            }
            recipesRepo.save(recipe);

            return ResponseEntity.ok().body(recipesRepo.findById(recipeId).orElseThrow(Exception::new));


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/getRecipes")
    public ResponseEntity<Set<Recipe>> getRecipes(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok().body(userRepo.findById(userId).orElseThrow(Exception::new).getRecipes());

        } catch (Exception exception) {
            return null;
        }
    }

    @PostMapping("/addRecipes")
    public ResponseEntity<String> addRecipe(@RequestBody Set<Recipe> recipes, @RequestParam Long userId, @RequestParam Long mealId) {
        try {
            User user = userRepo.findById(userId).orElseThrow(Exception::new);
            Meal meal = mealRepo.findById(mealId).orElseThrow(Exception::new);

            for (Recipe recipe : recipes) {
                Recipe recipe1 = recipesRepo.findById(recipe.getId()).orElseThrow(Exception::new);
                UserRecipes userRecipes = new UserRecipes();
                userRecipes.setMeal(meal);
                userRecipes.setUser(user);
                userRecipes.setRecipe(recipe1);

                userRecipesRepo.save(userRecipes);
            }


        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/getRecipesToday")
    public ResponseEntity<Set<UserRecipes>> getRecipesToday(@RequestParam Long userId) {
        try {
            Set<UserRecipes> userRecipes = userRepo.findById(userId).orElseThrow(Exception::new).getUserRecipes();
            Set<UserRecipes> userRecipesToday = new HashSet<>();
            for (UserRecipes userRecipes1 : userRecipes) {
                if (userRecipes1.getDate().compareTo(LocalDate.now()) == 0) {
                    userRecipesToday.add(userRecipes1);
                }
            }
            return ResponseEntity.ok().body(userRecipesToday);

        } catch (Exception exception) {
            return null;
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRecipesToday(@RequestParam Long recipeId, @RequestParam Long userId) throws Exception {
            UserRecipes userRecipes = userRecipesRepo.findById(recipeId).orElseThrow(Exception::new);
            userRecipesRepo.delete(userRecipes);
            return ResponseEntity.ok().body("Deleted!");
    }

    @DeleteMapping("/recipeDelete")
    public ResponseEntity<String> deleteRecipe(@RequestParam Long recipeId, @RequestParam Long userId) throws Exception {
        Recipe recipes = recipesRepo.findById(recipeId).orElseThrow(Exception::new);
        recipesRepo.delete(recipes);
        return ResponseEntity.ok().body("Deleted!");
    }
}