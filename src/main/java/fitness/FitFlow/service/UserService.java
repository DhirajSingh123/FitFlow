package fitness.FitFlow.service;

import fitness.FitFlow.model.User;
import fitness.FitFlow.repo.UserRepo;
import fitness.FitFlow.utility.BaseRestResponse;
import fitness.FitFlow.utility.Constents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Date;

@Component
public class UserService {

    @Autowired
    UserRepo userRepo;

    @CacheEvict(value = "allUser", allEntries = true)
    public ResponseEntity<BaseRestResponse<String>> save(User user) {

        try{
            Optional<User> res=userRepo.findByPhoneNo(user.getPhoneNo());
            if(res.isEmpty()){
                Date joiningDate = new Date();
                user.setJoiningDate(joiningDate);
                userRepo.save(user);
            }
            else {
                return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "Phone No already associated with existing user ",200, null));
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.EXCEPTION, "Missing required fields", 204,e.getMessage()));
        }

        return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.SUCCESS, "User added successfully",200, "User Name:"+user.getName()));



    }

    @Cacheable("allUser")
    public BaseRestResponse<List<User>>  findAllUsers() {
        BaseRestResponse response =new BaseRestResponse();


        List<User> users = userRepo.findAll();
        if(users.size()!=0){
            response.setData(users);
            response.setStatusCode(200);
            response.setStatus(Constents.SUCCESS);
            response.setMessage("Successfully get result");

        }
        else {
            response.setStatusCode(400);
            response.setStatus(Constents.FAILED);
            response.setMessage("Result not found");
        }

        return response;

    }

    public ResponseEntity<BaseRestResponse<User>> getUserByPhoneNo(String phone) {
        Optional<User> result = userRepo.findByPhoneNo(phone);
        return result.map(user -> ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.SUCCESS, "User found", 200, user))).orElseGet(() -> ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "User not found", 200, null)));
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
