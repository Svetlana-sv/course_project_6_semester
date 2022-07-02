package rest;

import db.User;
import db.UserParameters;
import db.repo.UserParametersRepo;
import db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserParametersRepo userParametersRepo;

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String login, @RequestParam String password) {
        System.out.println(login + " " + password);
        userRepo.findAll();
        return ResponseEntity.ok("Welcome!");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userRepo.save(user);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/changeParameters")
    public ResponseEntity<String> changeParameters(@RequestBody UserParameters userParameters) {
        try {
            UserParameters userParametersExisting = userParametersRepo.findById(userParameters.getId()).orElseThrow(Exception::new);
            userParametersExisting.setAge(userParameters.getAge());
            userParametersExisting.setHeight(userParameters.getHeight());
            userParametersExisting.setWeight(userParameters.getWeight());
            userParametersExisting.setCalorie_norm(userParameters.getCalorie_norm());
            userParametersExisting.setWater_norm(userParameters.getWater_norm());
            userParametersExisting.setCarbohydrate_norm(userParameters.getCarbohydrate_norm());
            userParametersExisting.setProtein_norm(userParameters.getProtein_norm());
            userParametersExisting.setFat_norm(userParameters.getFat_norm());
//            System.out.println(userParameters.getFat_norm());
            userParametersRepo.save(userParametersExisting);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }
}
