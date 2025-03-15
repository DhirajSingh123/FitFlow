package fitness.FitFlow.fitFlowController;


import fitness.FitFlow.model.User;
import fitness.FitFlow.service.UserService;
import fitness.FitFlow.tools.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetails {

    @Autowired
    User user;
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/getUser/{phoneNo}")
    public RestResponse getUser(@PathVariable String phoneNo){
        return userService.getUserById(phoneNo);
    }

    @DeleteMapping("/deleteUser/{phoneNo}")
    public String deleteUser(@PathVariable String phoneNo){
        return userService.deleteUserById(phoneNo);
    }

    @PutMapping("/updateUser/{phoneNo}")
    public String updateUser(@PathVariable String phoneNo,@RequestBody User user){
        return userService.updateUser(phoneNo,user);
    }

}
