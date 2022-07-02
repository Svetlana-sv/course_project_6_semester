package rest;

import db.Product;
import db.User;
import db.UserParameters;
import db.repo.ProductsRepo;
import db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    UserRepo userRepo;

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
}
