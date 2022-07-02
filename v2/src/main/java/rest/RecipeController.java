package rest;

import db.Product;
import db.Recipe;
import db.User;
import db.repo.ProductsRepo;
import db.repo.RecipesRepo;
import db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<String> createRecipe(@RequestBody Recipe recipe, @RequestParam Long userId) {
        try {
            recipe = recipesRepo.save(recipe);
            User user = userRepo.findById(userId).orElseThrow(Exception::new);
            Set<Recipe> recipes = user.getRecipes();
            recipes.add(recipe);
            user.setRecipes(recipes);
            userRepo.save(user);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }

    @PostMapping("/add-products")
    public ResponseEntity<Object> createRecipe(@RequestBody List<Product> products, @RequestParam Long recipeId) {
        try {
            Recipe recipe = recipesRepo.findById(recipeId).orElseThrow(Exception::new);
            for (Product product: products){
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
    public ResponseEntity<Set<Recipe>> getProducts(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok().body(userRepo.findById(userId).orElseThrow(Exception::new).getRecipes());

        }catch (Exception exception){
            return null;
        }
    }


}
