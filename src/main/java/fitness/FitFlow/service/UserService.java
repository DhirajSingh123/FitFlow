package fitness.FitFlow.service;

import fitness.FitFlow.model.FitnessSubscription;
import fitness.FitFlow.model.User;
import fitness.FitFlow.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    UserRepo userRepo;

    public String save(User user) {

        try{
            Optional<User> res=userRepo.findById(user.getFitnessId());
            if(res.isEmpty()){
                userRepo.save(user);
            }
            else {
                return "Subscription plan already exist please check ID";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }

        return "New User added successfully";

    }

    public List<User> findAllUsers() {
        return userRepo.findAll();

    }

    public User getUserById(int id) {
        Optional<User> result = userRepo.findById(id);
        return result.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public String deleteUserById(int id) {
        try{
            Optional<User> res=userRepo.findById(id);
            if(res.isEmpty()){
                userRepo.deleteById(id);
            }
            else {
                return "user not found";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "User Deleted successfully::" + id;
    }

    public String updateUser(User user) {

        Optional<User> result = userRepo.findById(user.getFitnessId());

        if (result.isPresent()) {
            userRepo.deleteById(user.getFitnessId());
            userRepo.save(user);
        } else {
            return "User not found for your given details::" + user.getFitnessId();
        }
        return "User update successfully";
    }
}
