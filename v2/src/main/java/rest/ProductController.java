package rest;

import db.*;
import db.repo.MealRepo;
import db.repo.ProductsRepo;
import db.repo.UserProductsRepo;
import db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MealRepo mealRepo;
    @Autowired
    UserProductsRepo userProductsRepo;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product, @RequestParam Long userId) {
        try {
            product = productsRepo.save(product);
            User user = userRepo.findById(userId).orElseThrow(Exception::new);
            Set<Product> products = user.getProducts();
            products.add(product);
            user.setProducts(products);
            userRepo.save(user);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/getProducts")
    public ResponseEntity<Set<Product>> getProducts(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok().body(userRepo.findById(userId).orElseThrow(Exception::new).getProducts());

        }catch (Exception exception){
            return null;
        }
    }

    @PostMapping("/addProducts")
    public ResponseEntity<String> addProduct(@RequestBody Set<Product> products, @RequestParam Long userId, @RequestParam Long mealId) {
        try {
            User user = userRepo.findById(userId).orElseThrow(Exception::new);
            Meal meal = mealRepo.findById(mealId).orElseThrow(Exception::new);
//            Product product1 = productsRepo.findById(product.getId()).orElseThrow(Exception::new);
//
//            UserProducts userProducts = new UserProducts();
//            userProducts.setMeal(meal);
//            userProducts.setUser(user);
//            userProducts.setProduct(product1);
//
//            userProductsRepo.save(userProducts);

            for (Product product: products){
                Product product1 = productsRepo.findById(product.getId()).orElseThrow(Exception::new);

                UserProducts userProducts = new UserProducts();
                userProducts.setMeal(meal);
                userProducts.setUser(user);
                userProducts.setProduct(product1);
                userProductsRepo.save(userProducts);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/getProductsToday")
    public ResponseEntity<Set<UserProducts>> getProductsToday(@RequestParam Long userId) {
        try {
            Set<UserProducts> userProducts = userRepo.findById(userId).orElseThrow(Exception::new).getUserProducts();
            Set<UserProducts> userProductsToday = new HashSet<>();
            for (UserProducts userProducts1 : userProducts) {
                if (userProducts1.getDate().compareTo(LocalDate.now()) == 0) {
                    userProductsToday.add(userProducts1);
                }
            }
            return ResponseEntity.ok().body(userProductsToday);

        } catch (Exception exception) {
            return null;
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProductsToday(@RequestParam Long productId, @RequestParam Long userId) throws Exception {
        UserProducts userProducts = userProductsRepo.findById(productId).orElseThrow(Exception::new);
        userProductsRepo.delete(userProducts);
        return ResponseEntity.ok().body("Deleted!");
    }
}
