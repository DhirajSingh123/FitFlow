package fitness.FitFlow.service;

import fitness.FitFlow.model.User;
import fitness.FitFlow.repo.UserRepo;
import fitness.FitFlow.utility.BaseRestResponse;
import fitness.FitFlow.utility.Constents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Date;

@Component
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepo userRepo;


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

    public ResponseEntity<BaseRestResponse<List<User>>> findAllUsers() {
        BaseRestResponse<List<User>> response = new BaseRestResponse<>();

        try{
            List<User> users = userRepo.findAll();
            response.setData(users);
            response.setMessage("Users fetched successfully");
            response.setStatus("success");
            response.setStatusCode(200);
        }
        catch (Exception e){

            log.info("Something wrong while getting response from the DB");

        }


        return ResponseEntity.ok(response);
    }

    




    public ResponseEntity<BaseRestResponse<User>> getUserByPhoneNo(String phone) {

        Optional<User> result = userRepo.findByPhoneNo(phone);
//        if(result.isEmpty()){
//            return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "User not found",200, null));
//        }
//
//        return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.SUCCESS, "User found",200, result.get()));

        return result.map(user -> ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.SUCCESS, "User found", 200, user))).orElseGet(() -> ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "User not found", 200, null)));
    }

    public ResponseEntity<BaseRestResponse<String>> deleteUserById(String phoneNo) {
        try{
            Optional<User> res=userRepo.findByPhoneNo(phoneNo);
            if(res.isPresent()){
                userRepo.deleteUserByPhoneNo(phoneNo);
            }
            else {
                return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "User not registered with this no",200, null));
            }
            return ResponseEntity.ok().body(new BaseRestResponse<>(Constents.SUCCESS, "User Deleted Successfully",200, null));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.FAILED, "User not registered with this no",200, null));

    }

    public ResponseEntity<BaseRestResponse<String>>  updateUser(String phoneNo,User updatedUser) {
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
            return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.SUCCESS,"User update successfully",200,null));
        } else {
            return ResponseEntity.badRequest().body(new BaseRestResponse<>(Constents.SUCCESS,"User not update successfully",200,null));
        }
    }

}
