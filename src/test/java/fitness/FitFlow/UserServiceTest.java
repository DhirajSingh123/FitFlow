package fitness.FitFlow;


import fitness.FitFlow.model.User;
import fitness.FitFlow.repo.UserRepo;
import fitness.FitFlow.service.UserService;
import fitness.FitFlow.utility.BaseRestResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    User user;

    //
    @Mock
    UserRepo userRepo;
    //
    @InjectMocks
    UserService userService;
    //basic test feature
    @Test
    public void showMessage() {
        assertEquals(1, 1);
    }

    @Test
    public void getUser(){
        User user = new User();
        user.setPhoneNo("9919423616");
        user.setName("Dhiraj Singh");
        user.setEmailId("singhdhiraj689@gmail.com");

        Mockito.when(userRepo.findByPhoneNo("9919423616")).thenReturn(Optional.of(user));
        ResponseEntity<BaseRestResponse<User>> userResponse= userService.getUserByPhoneNo("9919423616");
        System.out.println(userResponse);
        assertEquals(userResponse.getBody().getData().getName(),"Dhiraj Singh");
    }

	
}
