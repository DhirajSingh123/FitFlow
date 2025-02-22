package fitness.FitFlow.service;

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
        userRepo.save(user);
        return "User Saved Successfully!!";
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();

    }


    public User getUserById(int id) {
        Optional<User> result = userRepo.findById(id);
        return result.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public String deleteUserById(int id) {
        userRepo.deleteById(id);
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
