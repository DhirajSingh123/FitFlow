package fitness.FitFlow.fitFlowController;


import fitness.FitFlow.model.User;
import fitness.FitFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    User user;
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
