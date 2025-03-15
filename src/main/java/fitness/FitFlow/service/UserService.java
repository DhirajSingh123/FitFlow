package fitness.FitFlow.service;

import fitness.FitFlow.model.User;
import fitness.FitFlow.repo.UserRepo;
import fitness.FitFlow.tools.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Date;

@Component
public class UserService {

    @Autowired
    UserRepo userRepo;

    public String save(User user) {

        try{
            Optional<User> res=userRepo.findByPhoneNo(user.getPhoneNo());
            if(res.isEmpty()){
                Date joiningDate = new Date();
                user.setJoiningDate(joiningDate);
                userRepo.save(user);
            }
            else {
                return "Phone no already in used";
            }
        }
        catch (Exception e){
            return e.getMessage();
        }

        return "User added successfully";

    }

    public List<User> findAllUsers() {
        return userRepo.findAll();

    }

    public RestResponse getUserById(String phone) {

        RestResponse res = new RestResponse();
        Optional<User> result = userRepo.findByPhoneNo(phone);

        if(result.isEmpty()){
            res.setStatusCode(204);
            res.setStatusMessage("User not found please check user phone no");
            return res;
        }

        res.setObject(result.get());
        res.setStatusCode(200);
        res.setStatusMessage("Success");
        return res;
    }

    public String deleteUserById(String phoneNo) {
        try{
            Optional<User> res=userRepo.findByPhoneNo(phoneNo);
            if(res.isPresent()){
                userRepo.deleteUserByPhoneNo(phoneNo);
            }
            else {
                return "User not registered with this no ";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "User Deleted successfully::" + phoneNo;
    }

    public String updateUser(String phoneNo,User updatedUser) {
        Optional<User> existingUserOptional = userRepo.findByPhoneNo(phoneNo);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            if (updatedUser.getName() != null && !Objects.equals(updatedUser.getName(), "string")) {
                existingUser.setName(updatedUser.getName());
            }
            if (updatedUser.getEmailId() != null && !Objects.equals(updatedUser.getEmailId(), "string") ) {
                existingUser.setEmailId(updatedUser.getEmailId());
            }

            if (updatedUser.getPhoneNo() != null && !Objects.equals(updatedUser.getPhoneNo(), "string")) {
                existingUser.setPhoneNo(updatedUser.getPhoneNo());
            }

            userRepo.save(existingUser);
            return "User updated successfully";
        } else {
            return "User not found for the given phone number";
        }
    }

}
