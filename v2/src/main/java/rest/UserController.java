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
    public ResponseEntity<Long> login(@RequestParam String login, @RequestParam String password) {
        try {
            return ResponseEntity.ok().body(userRepo.findByLogin(login).orElseThrow(Exception::new).getId());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userRepo.save(user);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/getParameters")
    public ResponseEntity<UserParameters> getParameters(@RequestParam Long userId) {
        try {
            User user = userRepo.findById(userId).orElseThrow(Exception::new);
            UserParameters parameters = user.getParameters();
            return ResponseEntity.ok().body(parameters);

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @PostMapping("/changeParameters")
    public ResponseEntity<String> changeParameters(@RequestBody UserParameters userParameters, @RequestParam Long userId) {
        try {
            User user = userRepo.findById(userId).orElseThrow(Exception::new);
            UserParameters parameters = user.getParameters();

            parameters.setAge(userParameters.getAge());
            parameters.setHeight(userParameters.getHeight());
            parameters.setWeight(userParameters.getWeight());
            parameters.setCalorie_norm(userParameters.getCalorie_norm());
            parameters.setWater_norm(userParameters.getWater_norm());
            parameters.setCarbohydrate_norm(userParameters.getCarbohydrate_norm());
            parameters.setProtein_norm(userParameters.getProtein_norm());
            parameters.setFat_norm(userParameters.getFat_norm());
            parameters.setGender(userParameters.getGender());
            userRepo.save(user);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok("Saved");
    }
}
