package fitness.FitFlow.fitFlowController;


import fitness.FitFlow.model.User;
import fitness.FitFlow.service.UserService;
import fitness.FitFlow.utility.BaseRestResponse;
import fitness.FitFlow.utility.Constents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetails {

    @Autowired
    User user;
    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<BaseRestResponse<String>> saveUser(@RequestBody User user){
        if (user.getName() == null || user.getEmailId() == null) {
            return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "Missing required fields",403, null));
        }
        return userService.save(user);
    }

    @GetMapping("/allUsers")
//    public List<User> getAllUsers(){
//
//        return userService.findAllUsers();
//    }
    public BaseRestResponse getAllUsers(){

        return userService.findAllUsers();
    }

    @GetMapping("/getUser/{phoneNo}")
    public ResponseEntity<BaseRestResponse<User>> getUser(@PathVariable String phoneNo){
        if (phoneNo == null || phoneNo.isEmpty()) {
            return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "Missing required phone no",403, null));
        }
        return userService.getUserByPhoneNo(phoneNo);
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
